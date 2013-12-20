
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
object contactOP extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.2*/("""<div class="row">
		<div class="col-xs-12">
		<h3>
			<span class="tag-gn">E</span> OP聯絡事項：
		</h3>
		</div>
	</div>
	
	<div class="row">
		<div class="col-xs-12">
			<table width="100%" border="0" cellspacing="0" class="tb-1">
			<tr>
				<th>OP選單</th>
			</tr>
			<tr>
				<td>
				<input type="checkbox" name="opValue" value="EmpNo,EmpName,EmpEmail" />
				EmpNo EmpName
				</td>
			</tr>
			<tr>
				<td>此房型查無OP資料</td>
			</tr>
			</table>
		</div>
	</div>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:32 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/order/contactOP.scala.html
                    HASH: 5869bebe86f91c7266b795b12557ba210fe0ced5
                    MATRIX: 865->1
                    LINES: 29->1
                    -- GENERATED --
                */
            