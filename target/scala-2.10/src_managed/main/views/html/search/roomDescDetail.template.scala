
package views.html.search

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
object roomDescDetail extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[eztravel.rest.pojo.htl.RoomDescriptionInfo,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(info: eztravel.rest.pojo.htl.RoomDescriptionInfo):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import org.springframework.util.StringUtils


Seq[Any](format.raw/*1.52*/("""
"""),format.raw/*3.1*/("""				<!-- proj_name-->
			"""),_display_(Seq[Any](/*4.5*/if(StringUtils.hasText(info.getRoomtypeMark()))/*4.52*/ {_display_(Seq[Any](format.raw/*4.54*/("""
				<p>【專案名稱】</p><p>"""),_display_(Seq[Any](/*5.22*/info/*5.26*/.getRoomtypeMark())),format.raw/*5.44*/("""</p>
			""")))})),format.raw/*6.5*/("""
				<!-- proj_desc-->
			"""),_display_(Seq[Any](/*8.5*/if(StringUtils.hasText(info.getProjDesc()))/*8.48*/ {_display_(Seq[Any](format.raw/*8.50*/("""
				<p>【內容說明】</p><p>
				"""),_display_(Seq[Any](/*10.6*/Html(eztravel.rest.util.common.StringUtils.transMultiline(info.getProjDesc())))),format.raw/*10.84*/("""
			""")))})),format.raw/*11.5*/("""
				<!--bed and food setup-->
				<p>"""),_display_(Seq[Any](/*13.9*/if(!"Y".equals(info.getAddBedYn()))/*13.44*/ {_display_(Seq[Any](format.raw/*13.46*/("""不""")))})),format.raw/*13.48*/("""可加床(需以飯店回覆為主)</p>
			"""),_display_(Seq[Any](/*14.5*/if("Y".equals(info.getAddBedYn()))/*14.39*/ {_display_(Seq[Any](format.raw/*14.41*/("""
				<p>加床"""),_display_(Seq[Any](/*15.11*/if(!"Y".equals(info.getAddbedBfsYn()))/*15.49*/ {_display_(Seq[Any](format.raw/*15.51*/("""不""")))})),format.raw/*15.53*/("""附早餐</p>
			""")))})),format.raw/*16.5*/("""
				<p>"""),_display_(Seq[Any](/*17.9*/if(!"Y".equals(info.getAddBreakfastYn()))/*17.50*/ {_display_(Seq[Any](format.raw/*17.52*/("""不""")))})),format.raw/*17.54*/("""可加早餐</p>
				<!-- equipment-->
			"""),_display_(Seq[Any](/*19.5*/if(StringUtils.hasText(info.getRoomInstallation()))/*19.56*/ {_display_(Seq[Any](format.raw/*19.58*/("""
				<p>【房型設備】</p>
				<p>"""),_display_(Seq[Any](/*21.9*/info/*21.13*/.getRoomInstallation())),format.raw/*21.35*/("""</p>
			""")))})))}
    }
    
    def render(info:eztravel.rest.pojo.htl.RoomDescriptionInfo): play.api.templates.HtmlFormat.Appendable = apply(info)
    
    def f:((eztravel.rest.pojo.htl.RoomDescriptionInfo) => play.api.templates.HtmlFormat.Appendable) = (info) => apply(info)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:31 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/search/roomDescDetail.scala.html
                    HASH: a56fbde81397046247e8dc2e5cd5b0661182311c
                    MATRIX: 826->1|1015->51|1043->99|1104->126|1159->173|1198->175|1256->198|1268->202|1307->220|1347->230|1410->259|1461->302|1500->304|1564->333|1664->411|1701->417|1777->458|1821->493|1861->495|1895->497|1953->520|1996->554|2036->556|2084->568|2131->606|2171->608|2205->610|2249->623|2294->633|2344->674|2384->676|2418->678|2490->715|2550->766|2590->768|2654->797|2667->801|2711->823
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|33->5|33->5|33->5|34->6|36->8|36->8|36->8|38->10|38->10|39->11|41->13|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|43->15|44->16|45->17|45->17|45->17|45->17|47->19|47->19|47->19|49->21|49->21|49->21
                    -- GENERATED --
                */
            