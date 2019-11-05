package king.max.utils;

import king.max.MainApplication;
import king.max.widget.LoadingWidget;

/**
 * Description: 加载框统一接口
 */
public class LoadingUtils {

    /**
     * 显示加载框
     */
    public static void show() {
        LoadingWidget.instance().show();
    }

    /**
     * 显示加载框
     *
     * @param text 加载中显示的文字
     */
    public static void show(String text) {
        LoadingWidget.instance().show(text);
    }

    /**
     * 显示加载框
     *
     * @param id 加载中显示的文字资源id
     */
    public static void show(int id) {
        LoadingWidget.instance().show(MainApplication.instance().getString(id));
    }

    /**
     * 隐藏加载框
     */
    public static void hide() {
        LoadingWidget.instance().hide();
    }
}
