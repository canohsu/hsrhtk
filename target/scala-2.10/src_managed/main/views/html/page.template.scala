
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
/**/
object page extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[pojo.Page,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(page: pojo.Page):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

<div class="col-xs-12 col-sm-7 col-md-9" style="margin-bottom: 15px; text-align:right;">
	<div class="pagination pagination-centered">
		<ul style="">
			<li><a href="javascript: void(0);""""),_display_(Seq[Any](/*6.39*/if(page.getPageNo() > 1)/*6.63*/ {_display_(Seq[Any](format.raw/*6.65*/(""" onclick="javascript: setPage('1');"""")))})),format.raw/*6.102*/(""">&lt;&lt;</a></li>
            <li><a href="javascript: void(0);""""),_display_(Seq[Any](/*7.48*/if(page.getPageNo() > 1)/*7.72*/ {_display_(Seq[Any](format.raw/*7.74*/(""" onclick="javascript: setPage('"""),_display_(Seq[Any](/*7.106*/(page.getPageNo() - 1))),format.raw/*7.128*/("""');"""")))})),format.raw/*7.133*/(""">&lt;</a></li>
            """),_display_(Seq[Any](/*8.14*/defining(if(page.getTotalPage() < 5 || page.getPageNo() - 2 < 1) 1 else if(page.getPageNo() + 2 > page.getTotalPage()) page.getTotalPage() - 4 else page.getPageNo() - 2)/*8.183*/ { from =>_display_(Seq[Any](format.raw/*8.193*/("""
            	"""),_display_(Seq[Any](/*9.15*/defining(if(page.getTotalPage() < 5 || page.getPageNo() + 2 > page.getTotalPage()) page.getTotalPage() else if(page.getPageNo() + 2 < 5) 5 else page.getPageNo() + 2)/*9.180*/ { end =>_display_(Seq[Any](format.raw/*9.189*/("""
					"""),_display_(Seq[Any](/*10.7*/for(i <- from to end) yield /*10.28*/ {_display_(Seq[Any](format.raw/*10.30*/("""
						<li><a href="javascript: void(0);""""),_display_(Seq[Any](/*11.42*/if(page.getPageNo() != i)/*11.67*/ {_display_(Seq[Any](format.raw/*11.69*/(""" onclick="javascript: setPage('"""),_display_(Seq[Any](/*11.101*/i)),format.raw/*11.102*/("""');"""")))}/*11.108*/else/*11.113*/{_display_(Seq[Any](format.raw/*11.114*/(""" style="font-weight:bold"""")))})),format.raw/*11.140*/(""">"""),_display_(Seq[Any](/*11.142*/i)),format.raw/*11.143*/("""</a></li>
					""")))})),format.raw/*12.7*/("""
            	""")))})),format.raw/*13.15*/("""
            """)))})),format.raw/*14.14*/("""
            <li><a href="javascript: void(0);""""),_display_(Seq[Any](/*15.48*/if(page.getPageNo() < page.getTotalPage())/*15.90*/{_display_(Seq[Any](format.raw/*15.91*/(""" onclick="javascript: setPage('"""),_display_(Seq[Any](/*15.123*/(page.getPageNo() + 1))),format.raw/*15.145*/("""');"""")))})),format.raw/*15.150*/(""">&gt;</a></li>
            <li><a href="javascript: void(0);""""),_display_(Seq[Any](/*16.48*/if(page.getPageNo() < page.getTotalPage())/*16.90*/{_display_(Seq[Any](format.raw/*16.91*/(""" onclick="javascript: setPage('"""),_display_(Seq[Any](/*16.123*/page/*16.127*/.getTotalPage())),format.raw/*16.142*/("""');"""")))})),format.raw/*16.147*/(""">&gt;&gt;</a></li>
		</ul>
	</div>
</div>"""))}
    }
    
    def render(page:pojo.Page): play.api.templates.HtmlFormat.Appendable = apply(page)
    
    def f:((pojo.Page) => play.api.templates.HtmlFormat.Appendable) = (page) => apply(page)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:20 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/page.scala.html
                    HASH: fdd1e9524a6cc47e6371ca952b57c61cac82c6b4
                    MATRIX: 776->1|887->18|1118->214|1150->238|1189->240|1258->277|1360->344|1392->368|1431->370|1499->402|1543->424|1580->429|1644->458|1822->627|1870->637|1921->653|2095->818|2142->827|2185->835|2222->856|2262->858|2341->901|2375->926|2415->928|2484->960|2508->961|2533->967|2547->972|2587->973|2646->999|2685->1001|2709->1002|2757->1019|2805->1035|2852->1050|2937->1099|2988->1141|3027->1142|3096->1174|3141->1196|3179->1201|3278->1264|3329->1306|3368->1307|3437->1339|3451->1343|3489->1358|3527->1363
                    LINES: 26->1|29->1|34->6|34->6|34->6|34->6|35->7|35->7|35->7|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|39->11|40->12|41->13|42->14|43->15|43->15|43->15|43->15|43->15|43->15|44->16|44->16|44->16|44->16|44->16|44->16|44->16
                    -- GENERATED --
                */
            