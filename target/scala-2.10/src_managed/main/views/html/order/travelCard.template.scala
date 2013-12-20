
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
object travelCard extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Integer,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(titleCount: Integer):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.23*/("""
	<div class="row">
		<div class="col-xs-12">
		<h3>
			<span class="tag-gn">"""),_display_(Seq[Any](/*5.26*/titleCount)),format.raw/*5.36*/("""</span> 是否使用公務人員國民旅遊卡：
		</h3>
		</div>
	</div>
	
	<div class="row">
	  <div class="col-xs-12">
	   <table width="100%" border="0" cellspacing="0" class="tb-1">
          <tr>
              <td colspan="2" align="left" valign="top" class="txt-gn line-dn" >
                  <h4><input type="radio" name="travelCardRd" value="不使用國旅卡" checked /> 不使用</h4>
              </td>
          </tr>
          <tr>
              <td width="32%" align="left" valign="top" class="txt-gn">
                    <h4><input type="radio" name="travelCardRd" value="使用國旅卡" /> 使用，要申請『強制休假補助費用』</h4>
              </td>
              <td align="left">
                   <p>
                     <span class="txt-s2 txt-or">(訂單交易資料轉入聯信中心之檢核系統時間為旅遊行程出發日後3天內)</span><br>
                     <a href="" target="_blank"><u>玉山銀行國民旅遊卡暨教師卡2%優惠說明。</u></a>
                   </p>
               </td>
          </tr>
	   </table>
	    <input type="hidden" name="travelCard" value='N' /> 
	  </div>
	</div>
		
		"""))}
    }
    
    def render(titleCount:Integer): play.api.templates.HtmlFormat.Appendable = apply(titleCount)
    
    def f:((Integer) => play.api.templates.HtmlFormat.Appendable) = (titleCount) => apply(titleCount)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:37 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/order/travelCard.scala.html
                    HASH: 3187a6c1ef572e3d943a22288db8e3dbc6b31eaa
                    MATRIX: 786->1|901->22|1018->104|1049->114
                    LINES: 26->1|29->1|33->5|33->5
                    -- GENERATED --
                */
            