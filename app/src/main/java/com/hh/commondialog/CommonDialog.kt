

import AlertController
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import com.hh.commondialog.R



/**
 * CommonDialog使用说明
 * new CommonDialog
 * //构建dilaog，第一个参数上下文，第二个参数dialog样式(不传的话默认样式)
 * .Builder(this)
 * //设置dialog的layout，可以传view，也可以传layoutId
 * .setContentView()
 * //设置layout布局中textview的文字，第一个参数view的id，第二个参数为具体内容(可以多次调用)
 * .setText()
 * //设置layout布局中view的点击事件，第一个参数view的id，第二个参数为OnclickListener(可以多次调用)
 * .setOnClickListener()
 * //设置layout布局的宽高，默认为warp_parent
 * .setWidthAndHeight()
 * //设置layout布局的宽度充满屏幕，默认不充满屏幕
 * .fullWidth()
 * //设置layout布局的显示于屏幕底部，默认显示在中(参数为boolean值：是否显示从底部弹出动画)
 * .formBottom()
 * //设置layout布局的显示位置，默认在屏幕中间
 * .forGravity()
 * //设置layout是否添加默认显示动画，默认无动画
 * .addDefaultAnimation()
 * //设置layout的显示动画
 * .setAnimations()
 * //设置dialog取消时的监听事件
 * .setOnCancelListener()
 * //设置dialog消失时的监听事件
 * .setOnDismissListener()
 * //设置dialog显示时点击返回键的处理
 * .setOnKeyListener()
 * //创建dialog
 * .create()
 * //显示dialog
 * .show();
 */

class CommonDialog(context: Context, themeResId: Int) : Dialog(context, themeResId) {

    val mAlert: AlertController = AlertController(this, window!!)
}
