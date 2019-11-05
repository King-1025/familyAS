package king.max.ui.listener;

import android.animation.Animator;

/**
 * Description: 动画结束监听
 */
public interface OnAnimationListener extends Animator.AnimatorListener {

    @Override
    default void onAnimationStart(Animator animation) {

    }

    @Override
    default void onAnimationEnd(Animator animation) {

    }

    @Override
    default void onAnimationCancel(Animator animation) {

    }

    @Override
    default void onAnimationRepeat(Animator animation) {

    }
}
