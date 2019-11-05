package king.max.utils;

import android.view.Gravity;

import androidx.annotation.StringRes;

import king.max.MainApplication;
import king.max.widget.NoticeWidget;

/**
 * Description: 统一Toast接口
 */
public class ToastUtils {

    public static final int LENGTH_SHORT = 0;
    public static final int LENGTH_LONG = 1;

    /**
     * 显示Toast
     *
     * @param id 字符串资源ID
     */
    public static void show(@StringRes int id) {
//        NoticeWidget.INSTANCE.showToast(MainApplication.instance().getString(id), Gravity.CENTER, ToastUtils.LENGTH_SHORT);
          NoticeUtils.show(id);
    }

    /**
     * 显示Toast
     *
     * @param content 提示信息
     */
    public static void show(String content) {
  //      NoticeWidget.instance().showToast(content, Gravity.CENTER, ToastUtils.LENGTH_SHORT);
          NoticeUtils.show(content);
    }

    /**
     * 显示Toast
     *
     * @param content 提示信息
     * @param gravity 显示位置
     */
    public static void show(String content, int gravity) {
//        NoticeWidget.INSTANCE.showToast(content, gravity, ToastUtils.LENGTH_SHORT);
    }

    /**
     * 显示Toast
     *
     * @param content  提示信息
     * @param gravity  显示位置
     * @param duration 显示时长
     */
    public static void show(String content, int gravity, int duration) {
  //      NoticeWidget.INSTANCE.showToast(content, gravity, duration);
    }
}
