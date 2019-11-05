package king.max.utils;

import king.max.ui.listener.OnDialogListener;
import king.max.widget.DialogWidget;

/**
 * Description: 对话框统一接口
 */
public class DialogUtils {

    /**
     * 显示对话框
     *
     * @param text 显示内容
     */
    public static void show(String text) {
        DialogWidget.instance().show(text);
    }

    /**
     * 显示对话框
     *
     * @param listener 回调接口
     */
    public static void show(OnDialogListener listener) {
        DialogWidget.instance().show(listener);
    }

    /**
     * 显示对话框
     *
     * @param id       文字资源ID
     * @param listener 回调接口
     */
    public static void show(int id, OnDialogListener listener) {
        DialogWidget.instance().show(id, listener);
    }

    /**
     * 显示对话框
     *
     * @param text     显示内容
     * @param listener 回调接口
     */
    public static void show(String text, OnDialogListener listener) {
        DialogWidget.instance().show(text, listener);
    }
}
