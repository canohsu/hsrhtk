
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
object odInfoHSR extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.2*/("""<table class="table-green2">
	<tbody>
		<tr>
			<th style="width:130px;">商品價格</th>
			<td>本網站上公佈的價格，包含套裝行程、飯店、與平假日的價格。不同出發日價格依天數、日期、人數、房型而不同，在網頁上看到的價格，為行程參考價，在確認付款網頁中的價格，才為實際售價，請在付款前仔細查看。對於旅客自行與飯店或交通公司達成的協議，與未包含於行程中的消費，本網站恕不負責。 
			</td>
		</tr>
		<tr>
			<th>訂購流程</th>
			<td>
Step1： 請參考月曆上的日期選擇，並利用線上付款，完成訂購流程。<br>
Step2： 若沒能於線上立即完成付款，請務必於提示有效期限內付款完成，3天內之訂單規定要線上即時完成付款，3天後之訂單付款期限保留至當日午夜24:00。 超逾時限系統將自動取消。<br>
Step3： 付款完成後，您的e-mail中會立即收到付款成功通知信函，詳細載明您的出發日期與行程資料，請自行列印保存。<br>
Step4： 住房者憑身分證件及付款成功通知信函辦理入住登記。入住登記時，請填寫實際住房者資料，若不符合規定，飯店有權補收差價或當場要求全額付費。<br>
Step5： 客服人員預計於訂購完成三個工作天後，將您的高鐵車票郵寄到您指定的地址，請攜帶搭車。<br>
			</td>
		</tr>
		<tr>
			<th>重要聲明</th>
			<td>
※自主遊商品(飯店+高鐵)不得改期。<br>
※自主遊商品(飯店+高鐵)須同時取消飯店及高鐵，不得取消單一商品。亦不得改期。<br>
自主遊商品（飯店＋高鐵）取消相關規定：<br>
A. 自主遊商品(飯店+高鐵)於第一晚飯店入住日(不含)，前28天通知辦理取消，全額退費(不收任何手續費)。<br>
B. 自主遊商品(飯店+高鐵)於第一晚飯店入住日(不含)，前6天至27天內通知辦理取消，且高鐵車票必須於通知辦理取消之次日送回易遊網任一門市櫃檯，收取2％取消費。<br>
C.自主遊商品(飯店+高鐵)於第一晚飯店入住日(不含)，前3天至5天內通知辦理取消，且高鐵車票必須於通知辦理取消之次日送回易遊網任一門市櫃檯，收取12％取消費。<br>
D.自主遊商品(飯店+高鐵)於第一晚飯店入住日(不含)，前2天內通知辦理取消，且高鐵車票必須於通知辦理取消之次日送回易遊網任一門市櫃檯，收取55％取消費。<br>
E.自主遊商品(飯店+高鐵)於第一晚飯店入住日前一天及當天通知辦理取消訂房，收取100％取消費。<br>
※如遇農曆春節、寒暑假、特殊展期、國定假日及前夕或飯店特殊專案，飯店取消規定需依各房型內之說明公告為基準，取消費用將高於前述規定，不適用自主遊商品(飯店+高鐵)取消規定，敬請見諒。<br>
			</td>
		</tr>
		<tr>
			<th>其他注意事項</th>
			<td>
1.為完成您訂購之商品，易遊網須將必要之旅客個人資料交付予配合之服務提供業者(如航空公司、訂房中心、國內外旅行業者、飯店等)進行作業，並依規約課予配合之服務提供業者依「個人資料保護法」之原則處理旅客資料。相關法律政策請參考 <a target="_blank" href="http://www.eztravel.com.tw/service/privacy.htm?fr=hmindex"><b><font color="#FF0000">隱私權保護政策及個資聲明</font></b></a>。<br>
2.自95年7月1日起，不分旅遊網或購物網，消費滿 200 元以上就可累積 eMoney （點數依各商品不同提撥）。<a href="http://www.eztravel.com.tw/member/emoney/guide.htm" target="_blank">eMoney活動辦法說明</a>
			</td>
		</tr>
		<tr>
			<th>旅行業代收轉付收據</th>
			<td>易遊網旅行社將依據您在本網上訂購並完成交易的內容及價格開立『旅行業代收轉付收據』（非發票但效力等同發票），並依您訂購時選擇不寄送（保存於本公司）或要寄送處理；如需寄送則請詳細填寫公司名稱、統一編號、寄送地址等資料，我們將於收款完成後一週內以平信寄出。
			</td>
		</tr>
	</tbody>
	</table>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:32 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/order/odInfoHSR.scala.html
                    HASH: ad28ddbfdce46a404290be3c51154641f6bed1ee
                    MATRIX: 865->1
                    LINES: 29->1
                    -- GENERATED --
                */
            