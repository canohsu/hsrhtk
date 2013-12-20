
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
object contactWay extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Integer,models.enums.BusinessType,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(titleCount: Integer, role: models.enums.BusinessType):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.enums.BusinessType


Seq[Any](format.raw/*1.56*/("""
"""),format.raw/*3.1*/("""	<div class="row">
		<div class="col-xs-12">
		<h3>
			<span class="tag-gn">"""),_display_(Seq[Any](/*6.26*/titleCount)),format.raw/*6.36*/("""</span> 聯絡方式偏好："""),_display_(Seq[Any](/*6.52*/if(BusinessType.WEBORDER == role)/*6.85*/ {_display_(Seq[Any](format.raw/*6.87*/("""<h6>(客服人員訂購,可不填)</h6>""")))})),format.raw/*6.109*/("""
		</h3>
		</div>
	</div>
	
	<div class="row">
		<div class="col-xs-12">
		<table width="100%" border="0" cellspacing="0" class="tb-1">
		<tr>
		  <td align="left" valign="middle" colspan="2">
			<h4><input type="radio" name="relateInfoRd" value="EMAIL_SMS" checked/> Email 或簡訊</h4>
		  </td>
		</tr>
		<tr>
		  <td width="22%" align="left" valign="middle">
			<h4><input type="radio" name="relateInfoRd" value="PHONE" /> 電話，較方便接聽的時間</h4>
		  </td>
		  <td>
			<input type='radio' name='relateInfoVal' value='PHONE_09_12' disabled /> 電話09:00-12:00
			 <span style='margin-left:1.7em'></span>
			<input type='radio' name='relateInfoVal' value='PHONE_12_14' disabled /> 電話12:00:14:00
			 <span style='margin-left:1.7em' ></span>
			<input type='radio' name='relateInfoVal' value='PHONE_14_18' disabled /> 電話14:00-18:00
			 <br>
			<input type='radio' name='relateInfoVal' value='PHONE_18_22' disabled /> 電話18:00-22:00
			 <span style='margin-left:1.7em' ></span>
			<input type='radio' name='relateInfoVal' value='PHONE_ANY_TIME' disabled /> 電話以上時間內皆可
		  </td>
			<input type="hidden" name="relatedInfo" value="XX" />
		</tr>
		</table>
		</div>
	</div>"""))}
    }
    
    def render(titleCount:Integer,role:models.enums.BusinessType): play.api.templates.HtmlFormat.Appendable = apply(titleCount,role)
    
    def f:((Integer,models.enums.BusinessType) => play.api.templates.HtmlFormat.Appendable) = (titleCount,role) => apply(titleCount,role)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:34 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/order/contactWay.scala.html
                    HASH: ea5a9ec50d19b38017659c264ba735fae25db660
                    MATRIX: 812->1|994->55|1022->92|1137->172|1168->182|1219->198|1260->231|1299->233|1353->255
                    LINES: 26->1|30->1|31->3|34->6|34->6|34->6|34->6|34->6|34->6
                    -- GENERATED --
                */
            