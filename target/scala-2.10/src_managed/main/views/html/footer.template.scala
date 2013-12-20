
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/* footer Template File */
object footer extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /* footer Template File */
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*2.1*/("""<!---- FOOTER ---->
	<footer class="container">
	<div style="padding: 0px; font-weight: 200; font-size: 0.8em;">
		<p style="text-align: center; margin: 20px;">
｜ 上一頁 ｜ 回首頁 ｜ 客服信箱 ｜ 網站地圖 ｜ <br/>
｜ 國外旅遊 ｜ 國外自由行 ｜ 國際機票 ｜ 國際訂房 ｜ 航空假期 ｜<br/>
｜ 國內旅遊 ｜ 國內機票 ｜ 國內訂房 ｜ 火車旅遊 ｜ 高鐵旅行 ｜ 台灣觀光計程車 ｜ 飛行遊記 ｜ 巴士旅遊 ｜ 玩樂票券 ｜ <br/>
		</p>
		<p style="text-align: center; margin: 20px;">
訂購諮詢訂購諮詢 4066-6777 ( 苗栗請撥 4266-6777，金門、台東請撥 4666-6777，馬祖請撥 02-4066-6777 )<br/>
55678手機易遊通 55678手機易遊通 ( 中華電信、遠傳電信、台灣大哥大適用 )
		</p>
		<p style="text-align: center; margin: 20px;">
全國服務網全國服務網  ( 易遊網總公司、門市、高鐵服務站 )<br/>
易遊網旅行社股份有限公司　交觀綜字2105號　旅行社品質保障協會91字第北1204號。易遊網版權所有 ©2000 - 2014 ezTravel Co., Ltd. all rights reserved.
		</p>
	</div>
	</footer>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:20 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/footer.scala.html
                    HASH: eef19d63af8d6cc0b53511ded3e5062a07541bbf
                    MATRIX: 900->28
                    LINES: 29->2
                    -- GENERATED --
                */
            