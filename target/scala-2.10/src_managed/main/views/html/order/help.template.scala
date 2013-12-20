
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
object help extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Integer,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(titleCount: Integer):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.23*/("""
	<div class="row">
		<div class="col-xs-12">
		<h3>
			<span class="tag-gn">"""),_display_(Seq[Any](/*5.26*/titleCount)),format.raw/*5.36*/("""</span> 需協助事項：
		</h3>
		</div>
	</div>
	
    <div class="row">
	   <div class="col-xs-12">
		<textarea placeholder="" id="taRemark" name="taRemark" style="height:70px;width:100%;*width:99%;" class="tb-1" ></textarea>
		</div>
	</div>"""))}
    }
    
    def render(titleCount:Integer): play.api.templates.HtmlFormat.Appendable = apply(titleCount)
    
    def f:((Integer) => play.api.templates.HtmlFormat.Appendable) = (titleCount) => apply(titleCount)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:37 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/order/help.scala.html
                    HASH: f67dfc7779c632f3e66c102d256cbc44b26a8f63
                    MATRIX: 780->1|895->22|1012->104|1043->114
                    LINES: 26->1|29->1|33->5|33->5
                    -- GENERATED --
                */
            