package king.max.ui.listener;

/**
 * Description: 对话框点击监听回调接口
 */
public interface OnDialogListener {

    /**
     * 按钮事件回调
     *
     * @param isOK 按钮 true:确定 false 取消
     */
    default void onClick(boolean isOK) {
    }
}
