package king.max.ui.listener;

import androidx.annotation.NonNull;

import java.util.List;

/**
 * Description: 权限请求回调
 */
public interface OnPermissionRequestListener {

    /**
     * 权限请求回调
     *
     * @param authorize   是否全部成功授权
     * @param permissions 未授权权限列表
     */
    void onPermissionRequest(boolean authorize, @NonNull List<String> permissions);
}
