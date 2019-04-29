package com.progmob.letstour.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.goka.kenburnsview.LoopViewPager;

import java.util.List;
import java.util.Random;

/**
 * Created by katsuyagoto on 2015/04/17, Modified by Herlambang on 2019/01/09
 */
public class KenBurnsEffect extends FrameLayout {

    private enum LoadType {
        String,      // A file path, or a uri or url (default)
        ResourceID,  // The id of the resource containing the image
        MIXING       // String & Resource
    }

    private LoadType mLoadType = LoadType.String;

    private static final int NUM_OF_IMAGE_VIEWS = 3;

    private static final String PROPERTY_ALPHA = "alpha";

    private final Handler mHandler;

    private Context mContext;

    private ImageView[] mImageViews;

    private FrameLayout mRootLayout;

    private final Random mRandom = new Random();

    private int mSwapMs = 20000;

    private int mFadeInOutMs = 500;

    private float maxScaleFactor = 1.5F;

    private float minScaleFactor = 1.0F;

    private int mPosition = 0;

    private int mPreviousPosition = 0;

    private int mActiveImageIndex = -1;

    private List<String> mStrings;

    private List<Integer> mResourceIDs;

    private List<Object> mMixingList;

    private LoopViewPager mLoopViewPager;

    private ImageView.ScaleType mScaleType = null;

    private static int sCachedSizeForLoadType;


    public KenBurnsEffect(Context context) {
        this(context, null);
    }

    public KenBurnsEffect(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public KenBurnsEffect(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mHandler = new Handler();
        mContext = context;
    }

    public void setScaleType(ImageView.ScaleType mScaleType) {
        this.mScaleType = mScaleType;
    }

    public void setPager(LoopViewPager mPager) {
        this.mLoopViewPager = mPager;
    }

    public void forceSelected(int position) {
        mPreviousPosition = mPosition;
        if (mHandler != null) {
            stopKenBurnsAnimation();
            startForceKenBurnsAnimation();
        }
        mPosition = position;
    }


    private void forceSwapImage() {

        if (mImageViews.length <= 0) {
            return;
        }

        if (mActiveImageIndex == -1) {
            mActiveImageIndex = 0;
            animate(mImageViews[mActiveImageIndex]);
            return;
        }

        int inactiveIndex = mActiveImageIndex;

        if (mPreviousPosition >= mPosition) {
            mActiveImageIndex = swapDirection(mActiveImageIndex, true);
        } else {
            mActiveImageIndex = swapDirection(mActiveImageIndex, false);
        }

        if (mPreviousPosition == 0 && mPosition == getSizeByLoadType() - 1) {
            mActiveImageIndex = swapDirection(mActiveImageIndex, true);
        }

        if (mPreviousPosition == getSizeByLoadType() - 1 && mPosition == 0) {
            mActiveImageIndex = swapDirection(mActiveImageIndex, false);
        }

        if (mActiveImageIndex >= mImageViews.length) {
            mActiveImageIndex = 0;
        }

        final ImageView activeImageView = mImageViews[mActiveImageIndex];
        loadImage(mActiveImageIndex, mPosition);
        activeImageView.setAlpha(0.0f);

        ImageView inactiveImageView = mImageViews[inactiveIndex];

        animate(activeImageView);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(mFadeInOutMs);
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(inactiveImageView, PROPERTY_ALPHA, 1.0f, 0.0f),
                ObjectAnimator.ofFloat(activeImageView, PROPERTY_ALPHA, 0.0f, 1.0f)
        );
        animatorSet.start();
    }

    private int swapDirection(final int activeIndex, boolean isPrevious) {
        if (activeIndex == 0) {
            if (isPrevious) {
                return 2;
            } else {
                return 1;
            }
        } else if (activeIndex == 1) {
            if (isPrevious) {
                return 0;
            } else {
                return 2;
            }

        } else if (activeIndex == 2) {
            if (isPrevious) {
                return 1;
            } else {
                return 0;
            }
        }
        return 0;
    }


    private void autoSwapImage() {

        if (mImageViews.length <= 0) {
            return;
        }

        if (mActiveImageIndex == -1) {
            mActiveImageIndex = 0;
            animate(mImageViews[mActiveImageIndex]);
            return;
        }

        int inactiveIndex = mActiveImageIndex;
        mActiveImageIndex = (1 + mActiveImageIndex);

        if (mActiveImageIndex >= mImageViews.length) {
            mActiveImageIndex = 0;
        }

        if (mLoopViewPager != null) {
            mPosition++;

            if (mPosition >= getSizeByLoadType()) {
                mPosition = 0;
            }

            mLoopViewPager.setCurrentItemAfterCancelListener(mPosition, false);
        }

        final ImageView activeImageView = mImageViews[mActiveImageIndex];
        loadImage(mActiveImageIndex, mPosition);
        activeImageView.setAlpha(0.0f);

        ImageView inactiveImageView = mImageViews[inactiveIndex];

        animate(activeImageView);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(mFadeInOutMs);
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(inactiveImageView, PROPERTY_ALPHA, 1.0f, 0.0f),
                ObjectAnimator.ofFloat(activeImageView, PROPERTY_ALPHA, 0.0f, 1.0f)
        );
        animatorSet.start();
    }

    private void start(View view, long duration, float fromScale, float toScale, float fromTranslationX,
                       float fromTranslationY, float toTranslationX, float toTranslationY) {
        view.setScaleX(fromScale);
        view.setScaleY(fromScale);
        view.setTranslationX(fromTranslationX);
        view.setTranslationY(fromTranslationY);
        ViewPropertyAnimator propertyAnimator = view.animate().
                translationX(toTranslationX).
                translationY(toTranslationY).
                scaleX(toScale).
                scaleY(toScale).
                setDuration(duration);
        propertyAnimator.start();
    }

    private float pickScale() {
        return this.minScaleFactor + this.mRandom.nextFloat() * (this.maxScaleFactor - this.minScaleFactor);
    }

    private float pickTranslation(int value, float ratio) {
        return value * (ratio - 1.0f) * (this.mRandom.nextFloat() - 0.5f);
    }

    public void animate(ImageView view) {
        float fromScale = pickScale();
        float toScale = pickScale();
        float fromTranslationX = pickTranslation(view.getWidth(), fromScale);
        float fromTranslationY = pickTranslation(view.getHeight(), fromScale);
        float toTranslationX = pickTranslation(view.getWidth(), toScale);
        float toTranslationY = pickTranslation(view.getHeight(), toScale);
        start(view, this.mSwapMs, fromScale, toScale, fromTranslationX, fromTranslationY, toTranslationX,
                toTranslationY);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startKenBurnsAnimation();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopKenBurnsAnimation();
    }

    private Runnable mSwapImageRunnable = new Runnable() {
        @Override
        public void run() {
            autoSwapImage();
            mHandler.postDelayed(mSwapImageRunnable, mSwapMs - mFadeInOutMs * 2);
        }
    };

    private Runnable mForceSwapImageRunnable = new Runnable() {
        @Override
        public void run() {
            forceSwapImage();
            mHandler.postDelayed(mSwapImageRunnable, mSwapMs - mFadeInOutMs * 2);
        }
    };

    private void stopKenBurnsAnimation() {
        mHandler.removeCallbacks(mSwapImageRunnable);
        mHandler.removeCallbacks(mForceSwapImageRunnable);
    }

    private void startKenBurnsAnimation() {
        mHandler.post(mSwapImageRunnable);
    }

    private void startForceKenBurnsAnimation() {
        mHandler.post(mForceSwapImageRunnable);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        View view = inflate(getContext(), com.goka.kenburnsview.R.layout.ken_burns_view, this);
        mRootLayout = (FrameLayout) view.findViewById(com.goka.kenburnsview.R.id.ken_burns_root);
    }

    public void initStrings(List<String> strings) {
        mLoadType = LoadType.String;
        sCachedSizeForLoadType = 0;
        mStrings = strings;
        if (mRootLayout != null) {
            initImageViews(mRootLayout);
        }
    }

    public void initResourceIDs(List<Integer> resourceIDs) {
        mLoadType = LoadType.ResourceID;
        sCachedSizeForLoadType = 0;
        mResourceIDs = resourceIDs;
        if (mRootLayout != null) {
            initImageViews(mRootLayout);
        }
    }

    public void initMixing(List<Object> mixingList) {
        mLoadType = LoadType.MIXING;
        sCachedSizeForLoadType = 0;
        mMixingList = mixingList;
        if (mRootLayout != null) {
            initImageViews(mRootLayout);
        }
    }

    private void initImageViews(FrameLayout root) {

        mImageViews = new ImageView[NUM_OF_IMAGE_VIEWS];

        for (int i = NUM_OF_IMAGE_VIEWS - 1; i >= 0; i--) {
            mImageViews[i] = new ImageView(mContext);

            if (i != 0) {
                mImageViews[i].setAlpha(0.0f);
            }

            if (mScaleType != null) {
                mImageViews[i].setScaleType(mScaleType);
            }

            mImageViews[i].setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));

            root.addView(mImageViews[i]);
        }

        loadImage(0, 0);
    }

    public ImageView[] getImages() {
        return mImageViews;
    }

    private void loadImage(final int activeIndex, final int position) {
        loadByGlide(position, activeIndex);

        int prePosition  = position - 1;
        int nextPosition = position + 1;

        if (prePosition < 0) {
            prePosition = getSizeByLoadType() - 1;
        }

        if (nextPosition > getSizeByLoadType() - 1) {
            nextPosition = 0;
        }

        if (activeIndex == 0) {
            if (position != prePosition) {
                loadByGlide(prePosition, 2);
            }
            if (position != nextPosition) {
                loadByGlide(nextPosition, 1);
            }
        } else if (activeIndex == 1) {
            if (position != prePosition) {
                loadByGlide(prePosition, 0);
            }
            if (position != nextPosition) {
                loadByGlide(nextPosition, 2);
            }
        } else if (activeIndex == 2) {
            if (position != prePosition) {
                loadByGlide(prePosition, 1);
            }
            if (position != nextPosition) {
                loadByGlide(nextPosition, 0);
            }
        }
    }

    private int getSizeByLoadType() {

        if (sCachedSizeForLoadType > 0) {
            return sCachedSizeForLoadType;
        }

        switch (mLoadType) {
            case String:
                sCachedSizeForLoadType = mStrings.size();
                break;
            case ResourceID:
                sCachedSizeForLoadType = mResourceIDs.size();
                break;
            case MIXING:
                sCachedSizeForLoadType = mMixingList.size();
                break;
        }
        return sCachedSizeForLoadType;
    }

    private void loadByGlide(final int position, final int imageIndex) {
        switch (mLoadType) {
            case String:
                Glide.with(mContext).load(mStrings.get(position)).into(mImageViews[imageIndex]);
                break;
            case ResourceID:
                Glide.with(mContext).load(mResourceIDs.get(position)).into(mImageViews[imageIndex]);
                break;
            case MIXING:
                Object object = mMixingList.get(position);
                if (object.getClass() == String.class) {
                    String string = (String) object;
                    Glide.with(mContext).load(string).into(mImageViews[imageIndex]);
                } else if (object.getClass() == Integer.class) {
                    Integer integer = (Integer) object;
                    Glide.with(mContext).load(integer).into(mImageViews[imageIndex]);
                }
                break;
        }
    }
}

