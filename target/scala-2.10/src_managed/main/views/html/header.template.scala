
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
/* header Template File */
object header extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /* header Template File */
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*2.1*/("""<!---- NAVBAR ---->
<div class="navbar navbar-inverse">
    <div class="container header">
        <div class="member-bar">
            <div class="member-area">
                <img class="member-bar-icon" src=""""),_display_(Seq[Any](/*7.52*/routes/*7.58*/.Assets.at("images/common/icon_phone.gif"))),format.raw/*7.100*/(""""/>我的訂單
                | <img class="member-bar-icon" src=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("images/common/icon_phone.gif"))),format.raw/*8.102*/(""""/>我的eMoney
                | <img class="member-bar-icon" src=""""),_display_(Seq[Any](/*9.54*/routes/*9.60*/.Assets.at("images/common/icon_phone.gif"))),format.raw/*9.102*/(""""/>會員服務
            </div>
            <div class="member-info">Hi~ 歡迎來到易遊網</div>
        </div>
        <a class="navbar-brand" href="#"> <img class="clogo"
            src=""""),_display_(Seq[Any](/*14.19*/routes/*14.25*/.Assets.at("images/common/logo_1.png"))),format.raw/*14.63*/("""" />
        </a>
    </div>
    <div class="hidden-xs">
        <div class="container tm-area">
            <div class="tm-bar">
                <div class="col-md-3 col-sm-3 tm-block">
                    <div class="tm-item col-md-6 col-sm-6">國外旅遊</div>
                    <div class="tm-item col-md-6 col-sm-6">國際機票</div>
                </div>
                <div class="col-md-3 col-sm-3 tm-block">
                    <div class="tm-item col-md-6 col-sm-6">國際訂房</div>
                    <div class="tm-item col-md-6 col-sm-6">國內旅遊</div>
                </div>
                <div class="col-md-3 col-sm-3 tm-block">
                    <div class="tm-item col-md-6 col-sm-6">國內機票</div>
                    <div class="tm-item col-md-6 col-sm-6">國內訂房</div>
                </div>
                <div class="col-md-3 col-sm-3 tm-block">
                    <div class="tm-item col-md-6 col-sm-6">高雄出發</div>
                    <div class="tm-item tm-last-item col-md-6 col-sm-6">頂級旅遊</div>
                </div>
            </div>
        </div>
    </div>
    <!-- <div class="tm-last-line"></div> -->
</div>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:20 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/header.scala.html
                    HASH: bb153a9255caf37ee9a3dc673b4a02b5767efc03
                    MATRIX: 900->28|1153->246|1167->252|1231->294|1328->356|1342->362|1406->404|1507->470|1521->476|1585->518|1802->699|1817->705|1877->743
                    LINES: 29->2|34->7|34->7|34->7|35->8|35->8|35->8|36->9|36->9|36->9|41->14|41->14|41->14
                    -- GENERATED --
                */
            