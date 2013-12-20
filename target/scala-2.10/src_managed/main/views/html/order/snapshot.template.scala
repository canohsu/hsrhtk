
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
object snapshot extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[pojo.Order,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(order: pojo.Order):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import eztravel.rest.enums.hsr.HsrStation

import java.lang.String


Seq[Any](format.raw/*1.21*/("""
"""),_display_(Seq[Any](/*4.2*/main/*4.6*/ {_display_(Seq[Any](format.raw/*4.8*/("""
<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<span class="txt-s">您的訂單編號：</span>"""),_display_(Seq[Any](/*8.39*/order/*8.44*/.getOrderNo)),format.raw/*8.55*/("""
		</div>
	</div>
<!---------- 訂購明細 - Start ---------->
"""),_display_(Seq[Any](/*12.2*/orderDetail(1, order)/*12.23*/ {_display_(Seq[Any](format.raw/*12.25*/("""
""")))})),format.raw/*13.2*/("""
<!---------- 訂購明細 - End   ---------->

<!---------- 訂購需知 - Start ---------->
"""),_display_(Seq[Any](/*17.2*/odInfo(2)/*17.11*/ {_display_(Seq[Any](format.raw/*17.13*/("""
""")))})),format.raw/*18.2*/("""
<!---------- 訂購需知 - End   ---------->
</div>
""")))}/*21.2*/ {_display_(Seq[Any](format.raw/*21.4*/("""	
""")))}/*22.2*/ {_display_(Seq[Any](format.raw/*22.4*/("""
    """),_display_(Seq[Any](/*23.6*/header())),format.raw/*23.14*/("""
""")))}/*24.2*/ {_display_(Seq[Any](format.raw/*24.4*/("""
    """),_display_(Seq[Any](/*25.6*/footer())),format.raw/*25.14*/("""
""")))})))}
    }
    
    def render(order:pojo.Order): play.api.templates.HtmlFormat.Appendable = apply(order)
    
    def f:((pojo.Order) => play.api.templates.HtmlFormat.Appendable) = (order) => apply(order)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:33 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/order/snapshot.scala.html
                    HASH: a12684cfd3e1d1a84eb7bc9f131c409c263729ad
                    MATRIX: 787->1|967->20|1003->90|1014->94|1052->96|1195->204|1208->209|1240->220|1332->277|1362->298|1402->300|1435->302|1549->381|1567->390|1607->392|1640->394|1705->441|1744->443|1765->446|1804->448|1845->454|1875->462|1895->464|1934->466|1975->472|2005->480
                    LINES: 26->1|32->1|33->4|33->4|33->4|37->8|37->8|37->8|41->12|41->12|41->12|42->13|46->17|46->17|46->17|47->18|50->21|50->21|51->22|51->22|52->23|52->23|53->24|53->24|54->25|54->25
                    -- GENERATED --
                */
            