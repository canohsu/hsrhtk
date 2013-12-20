
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
object memberLogin extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Integer,models.pojo.User,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(titleCount: Integer, user: models.pojo.User):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.enums.BusinessType


Seq[Any](format.raw/*1.47*/("""
"""),_display_(Seq[Any](/*3.2*/if(BusinessType.B2B != user.getBusinessType())/*3.48*/ {_display_(Seq[Any](format.raw/*3.50*/("""
    <div class="row" id="loginTitle">
        <div class="col-xs-12 dotTitle"><span>"""),_display_(Seq[Any](/*5.48*/titleCount)),format.raw/*5.58*/("""</span> 會員登入：</div>
    </div>

	<div class="row" id="loginRow">
		<div class="col-xs-12 col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4" id="loginTable">
			<table class="table-green">
            <thead>
				<tr>
					<th colspan="2">請輸入會員帳號及密碼</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th style="width:5.5em;" id="loginIdText">
						"""),_display_(Seq[Any](/*19.8*/if(BusinessType.WEBORDER == user.getBusinessType())/*19.59*/ {_display_(Seq[Any](format.raw/*19.61*/("""員工編號""")))}/*19.67*/else/*19.72*/{_display_(Seq[Any](format.raw/*19.73*/("""帳　　號""")))})),format.raw/*19.78*/("""
					</th>
					<td>
						<input name="userId" type="text" size="20" placeholder="請輸入身份證字號" id="loginId" """),_display_(Seq[Any](/*22.87*/if(BusinessType.WEBORDER == user.getBusinessType())/*22.138*/ {_display_(Seq[Any](format.raw/*22.140*/("""value=""""),_display_(Seq[Any](/*22.148*/user/*22.152*/.getLoginId())),format.raw/*22.165*/(""""""")))})),format.raw/*22.167*/("""/>
						"""),_display_(Seq[Any](/*23.8*/if(BusinessType.WEBORDER != user.getBusinessType())/*23.59*/ {_display_(Seq[Any](format.raw/*23.61*/("""
							<span id="passportRemind">*外籍人士請輸入護照號碼</span>
						""")))})),format.raw/*25.8*/("""
					</td>
				</tr>
				<tr>
					<th>密　　碼</th>
					<td>
						<input name="userpwd" type="password" size="20" id="loginPwd" """),_display_(Seq[Any](/*31.70*/if(BusinessType.WEBORDER == user.getBusinessType())/*31.121*/ {_display_(Seq[Any](format.raw/*31.123*/("""value=""""),_display_(Seq[Any](/*31.131*/user/*31.135*/.getLoginPwd())),format.raw/*31.149*/(""""""")))})),format.raw/*31.151*/("""/>
						"""),_display_(Seq[Any](/*32.8*/if(BusinessType.WEBORDER != user.getBusinessType())/*32.59*/ {_display_(Seq[Any](format.raw/*32.61*/("""
							<a href="http://www.eztravel.com.tw/ezec/member/ec_pwd_qry.jsp" target="_blank" id="loginPwdQuery">查詢密碼</a>
						""")))})),format.raw/*34.8*/("""
					</td>
				</tr>
			</tbody>
			</table>
		</div>
	</div>
""")))})),format.raw/*41.2*/("""
	<div class="row" id="buttonRow">
		<div class="col-xs-12 text-center">
			<br>
	"""),_display_(Seq[Any](/*45.3*/user/*45.7*/.getBusinessType/*45.23*/ match/*45.29*/ {/*46.3*/case BusinessType.B2B =>/*46.27*/ {_display_(Seq[Any](format.raw/*46.29*/("""
			<button type="submit" class="btn btn-success btn-sm" id="nextButton">下一步</button>
		""")))}/*49.3*/case BusinessType.WEBORDER =>/*49.32*/ {_display_(Seq[Any](format.raw/*49.34*/("""
			<button type="submit" class="btn btn-success btn-sm" id="loginButton">客服登入</button>
		""")))}/*52.3*/case _ =>/*52.12*/ {_display_(Seq[Any](format.raw/*52.14*/("""
			<button type="submit" class="btn btn-success btn-sm" id="loginButton">會員登入</button>
			<a href="http://www.eztravel.com.tw/ezec/member/ec_join.jsp" target="_blank" id="addMember">免費加入會員</a>
		""")))}})),format.raw/*56.3*/("""
		</div>
	</div>
	<div id="waitingRow" class="row">登入中…</div>
	<div id="user" data-user='"""),format.raw/*60.28*/("""{"""),format.raw/*60.29*/(""""role":""""),_display_(Seq[Any](/*60.38*/user/*60.42*/.getBusinessType)),format.raw/*60.58*/("""""""),format.raw/*60.59*/("""}"""),format.raw/*60.60*/("""'></div>"""))}
    }
    
    def render(titleCount:Integer,user:models.pojo.User): play.api.templates.HtmlFormat.Appendable = apply(titleCount,user)
    
    def f:((Integer,models.pojo.User) => play.api.templates.HtmlFormat.Appendable) = (titleCount,user) => apply(titleCount,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:33 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/order/memberLogin.scala.html
                    HASH: 77467c2a12437115dd7f48a57c3d231b40c56c80
                    MATRIX: 804->1|977->46|1014->84|1068->130|1107->132|1230->220|1261->230|1661->595|1721->646|1761->648|1785->654|1798->659|1837->660|1874->665|2021->776|2082->827|2123->829|2168->837|2182->841|2218->854|2253->856|2299->867|2359->918|2399->920|2493->983|2664->1118|2725->1169|2766->1171|2811->1179|2825->1183|2862->1197|2897->1199|2943->1210|3003->1261|3043->1263|3199->1388|3301->1459|3423->1546|3435->1550|3460->1566|3475->1572|3485->1578|3518->1602|3558->1604|3667->1699|3705->1728|3745->1730|3856->1827|3874->1836|3914->1838|4146->2042|4268->2136|4297->2137|4342->2146|4355->2150|4393->2166|4422->2167|4451->2168
                    LINES: 26->1|30->1|31->3|31->3|31->3|33->5|33->5|47->19|47->19|47->19|47->19|47->19|47->19|47->19|50->22|50->22|50->22|50->22|50->22|50->22|50->22|51->23|51->23|51->23|53->25|59->31|59->31|59->31|59->31|59->31|59->31|59->31|60->32|60->32|60->32|62->34|69->41|73->45|73->45|73->45|73->45|73->46|73->46|73->46|75->49|75->49|75->49|77->52|77->52|77->52|80->56|84->60|84->60|84->60|84->60|84->60|84->60|84->60
                    -- GENERATED --
                */
            