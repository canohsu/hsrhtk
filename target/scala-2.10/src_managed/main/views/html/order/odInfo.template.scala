
package views.html.order

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
/**/
object odInfo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Integer,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(titleCount: Integer)(agreeCheck: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.41*/("""
    <div class="row" style="padding-top: 18px;">
        <div class="col-xs-12 dotTitle"><span>"""),_display_(Seq[Any](/*3.48*/titleCount)),format.raw/*3.58*/("""</span> 訂購需知：
        <font class="txt-sGreen">(為維護您的權益，請詳閱作業說明)</font>
        </div>
    </div>

	<div class="row">
		<div class="col-xs-12">
		<!-- <iframe frameborder="0" id="htltw_att" name="htltw_att" src='"""),_display_(Seq[Any](/*10.70*/routes/*10.76*/.Assets.at("html/odInfo_HSR.html"))),format.raw/*10.110*/("""' width="100%" onload="dyniframesize('htltw_att')"></iframe> -->
		"""),_display_(Seq[Any](/*11.4*/odInfoHSR())),format.raw/*11.15*/("""
		</div>
	</div>

	"""),_display_(Seq[Any](/*15.3*/agreeCheck)))}
    }
    
    def render(titleCount:Integer,agreeCheck:Html): play.api.templates.HtmlFormat.Appendable = apply(titleCount)(agreeCheck)
    
    def f:((Integer) => (Html) => play.api.templates.HtmlFormat.Appendable) = (titleCount) => (agreeCheck) => apply(titleCount)(agreeCheck)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:34 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/order/odInfo.scala.html
                    HASH: 10d0836c876c04b6f9b368f5b5a233f2e1713ad3
                    MATRIX: 787->1|920->40|1054->139|1085->149|1341->369|1356->375|1413->409|1517->478|1550->489|1610->514
                    LINES: 26->1|29->1|31->3|31->3|38->10|38->10|38->10|39->11|39->11|43->15
                    -- GENERATED --
                */
            