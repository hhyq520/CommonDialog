package com.hh.commondialog

import CommonDialog
import android.content.Context
import android.content.DialogInterface
import android.view.Gravity
import android.view.View
import android.view.ViewGroup

fun DialogUtil(block: CommonDialogBuild.() -> Unit): CommonDialog = CommonDialogBuild().apply(block).show()

class CommonDialogBuild{
    lateinit var context:Context
    val themeResId:Int=R.style.dialog

    lateinit var P: AlertController.AlertParams

    fun setPContext(mContext:Context) {
        context=mContext
        P=AlertController.AlertParams(context, themeResId)
    }

    fun setContentView(view: View) {
        P.mView = view
        P.mViewLayoutResId = 0
    }

    // 设置布局内容的layoutId
    fun setContentView(layoutId: Int) {
        P.mView = null
        P.mViewLayoutResId = layoutId
    }

    // 设置文本
    fun setText(viewId: Int, text: CharSequence) {
        P.mTextArray.put(viewId, text)
    }

    // 设置点击事件
    fun setOnClickListener(view: Int, listener: View.OnClickListener) {
        P.mClickArray.put(view, listener)
    }

    fun setVisibility(view: Int, visibility: Int) {
        P.mVisibility.put(view, visibility)
    }

    // 是否充满屏幕宽度
    fun fullWidth() {
        P.mWidth = ViewGroup.LayoutParams.MATCH_PARENT
    }

    fun fullHeight() {
        P.mHeight = ViewGroup.LayoutParams.MATCH_PARENT
    }



    /**
     * 从底部弹出
     *
     * @param isAnimation 是否有动画
     * @return
     */
    fun formBottom(isAnimation: Boolean) {
        if (isAnimation) {
            P.mAnimations = R.style.dialog_from_bottom_anim
        }
        P.mGravity = Gravity.BOTTOM
    }

    /**
     * 设置dialog在屏幕中显示的位置
     *
     * @param gravity
     * @return
     */
    fun forGravity(gravity: Int) {
        P.mGravity = gravity
    }

    /**
     * 设置Dialog的宽高
     *
     * @param width
     * @param height
     * @return
     */
    fun setWidthAndHeight(width: Int, height: Int) {
        P.mWidth = width
        P.mHeight = height
    }

    /***
     * 设置Dialog的宽度
     * */
    fun setWidth(width: Int) {
        P.mWidth = width
    }

    /**
     * 添加默认动画
     *
     * @return
     */
    fun addDefaultAnimation() {
        P.mAnimations = R.style.dialog_scale_anim
    }

    /**
     * 设置动画
     *
     * @param styleAnimation
     * @return
     */
    fun setAnimations(styleAnimation: Int) {
        P.mAnimations = styleAnimation
    }

    /**
     * 点击返回键是否可以消失
     */
    fun setCancelable(cancelable: Boolean) {
        P.mCancelable = cancelable
    }

    /**
     * 点击空白处是否可以取消
     */
    fun setCancelableOnTouchOutside(cancelableOnTouchOutside: Boolean) {
        P.mCancelableOnTouchOutside = cancelableOnTouchOutside
    }

    /**
     * 取消监听事件
     */
    fun setOnCancelListener(onCancelListener: DialogInterface.OnCancelListener) {
        P.mOnCancelListener = onCancelListener
    }

    /**
     * 消失监听事件
     */
    fun setOnDismissListener(onDismissListener: DialogInterface.OnDismissListener) {
        P.mOnDismissListener = onDismissListener
    }

    /**
     * 点击返回键监听事件
     */
    fun setOnKeyListener(onKeyListener: DialogInterface.OnKeyListener) {
        P.mOnKeyListener = onKeyListener
    }

    /**
     * 创建dialog
     *
     * @return
     */
    fun create(): CommonDialog {
        val dialog = CommonDialog(P.mContext, P.mThemeResId)
        P.apply(dialog.mAlert)
        dialog.setCancelable(P.mCancelable)
        dialog.setCanceledOnTouchOutside(P.mCancelableOnTouchOutside)
        dialog.setOnCancelListener(P.mOnCancelListener)
        dialog.setOnDismissListener(P.mOnDismissListener)
        if (P.mOnKeyListener != null) {
            dialog.setOnKeyListener(P.mOnKeyListener)
        }
        return dialog
    }

    /**
     * 显示dialog
     *
     * @return
     */
    fun show(): CommonDialog {
        val dialog = create()
        dialog.show()
        return dialog
    }
}