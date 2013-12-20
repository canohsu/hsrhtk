
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
object customerSource extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.2*/("""<div class="row">
		<div class="col-xs-12 text-center">
			<br>
            <!-- 進線來源、廣告來源 應該要撈DB -->
			進線來源：
			<select name='order_type'>
				<option value='PHONE'>電話</option>
				<option value='_55678'>55678</option>
			</select>
			廣告來源：
			<select name='ad_source' id='ad_source'>
				<option value='A'>直接進入易遊網</option>
				<option value='J'>電視廣告</option>
				<option value='B'>愛樂廣播電台</option>
				<option value='K'>報紙</option>
				<option value='C'>Yahoo旅遊頻道</option>
				<option value='D'>Yahoo引擎</option>
				<option value='E'>Google</option>
				<option value='F'>門市型錄DM/海報</option>
				<option value='G'>媒體報導</option>
				<option value='H'>親友推薦</option>
				<option value='I'>地緣關係(門市)</option>
				<option value='Z'>其他</option>
				<option value='_5'>訂購需求</option>
				<option value='_6'>特別團</option>
				<option value='_8'>旅展</option>
				<option value='L'>EzWeb inbound自由行</option>
			</select>
            <br>
		</div>
	</div>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:34 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/order/customerSource.scala.html
                    HASH: 3589f8dcf8d22ad9e2e91fdc7cd1bd0b36dd1903
                    MATRIX: 870->1
                    LINES: 29->1
                    -- GENERATED --
                */
            