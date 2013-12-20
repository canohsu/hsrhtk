
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
object serviceArea extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Integer,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(titleCount: Integer):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.23*/("""
	<div class="row">
		<div class="col-xs-12">
		<h3>
			<span class="tag-gn">"""),_display_(Seq[Any](/*5.26*/titleCount)),format.raw/*5.36*/("""</span> 服務區域：
		</h3>
		</div>
	</div>
	
 <div class="row">
  <div class="col-xs-12">
   	<div class="tb-1 txt-gn">
	     <input type="checkbox" name="chkTPE"  checked/> 台北
	     <input type="checkbox" name="chkHKK"  /><span class="hideChkHKK" >高雄</span>  
  	</div>  
  	<input type="hidden" name="service" value="TPE"  /> 
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
                    SOURCE: D:/2013project/hsrhtl/app/views/order/serviceArea.scala.html
                    HASH: 578800aa2b90f33e1ce96222f8987355eaebdc5a
                    MATRIX: 787->1|902->22|1019->104|1050->114
                    LINES: 26->1|29->1|33->5|33->5
                    -- GENERATED --
                */
            