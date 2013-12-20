
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
object customerSearchEC extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[pojo.Member],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(memberList: List[pojo.Member]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.33*/("""
"""),_display_(Seq[Any](/*2.2*/if(null == memberList || memberList.size() <= 0)/*2.50*/ {_display_(Seq[Any](format.raw/*2.52*/("""
        	  <script type="text/javascript" language="javascript" >
        	    <!--
        		  alert("查無此會員基本資料");
          		  window.close("searchCustID");
        	    -->
        	  </script>
""")))})),format.raw/*9.2*/("""

<!DOCTYPE html>
<html lang="zh-TW">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="Kiki Liu">

	<title>高鐵自主行</title>

	<!-- Bootstrap core CSS -->
	<link href=""""),_display_(Seq[Any](/*23.15*/routes/*23.21*/.Assets.at("css/bootstrap-3.0.2.css"))),format.raw/*23.58*/("""" rel="stylesheet">

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src=""""),_display_(Seq[Any](/*27.16*/routes/*27.22*/.Assets.at("jslib/html5shiv-3.7.0.min.js"))),format.raw/*27.64*/(""""></script>
	<script src=""""),_display_(Seq[Any](/*28.16*/routes/*28.22*/.Assets.at("jslib/respond-1.3.0.min.js"))),format.raw/*28.62*/(""""></script>
	<![endif]-->

	<script src=""""),_display_(Seq[Any](/*31.16*/routes/*31.22*/.Assets.at("jslib/jquery-1.9.1.min.js"))),format.raw/*31.61*/(""""></script>

	<!-- Custom styles for this page -->
	<link href=""""),_display_(Seq[Any](/*34.15*/routes/*34.21*/.Assets.at("css/carousel.css"))),format.raw/*34.51*/("""" rel="stylesheet">
</head>

<body>
    <script type="text/javascript" language="javascript" >
      <!--
        jQuery(document).ready(function()"""),format.raw/*40.42*/("""{"""),format.raw/*40.43*/("""
            $(':input[name="selTheCustInfo"]').each(function(index)"""),format.raw/*41.68*/("""{"""),format.raw/*41.69*/("""
                $(this).click(function()"""),format.raw/*42.41*/("""{"""),format.raw/*42.42*/("""
                  window.opener.document.getElementsByName("fdContName1")[0].value = $.trim($('span.css_name_chn').eq(index).text());
                  window.opener.document.getElementsByName("memberName")[0].value = $.trim($('span.css_name_chn').eq(index).text());
                  window.opener.document.getElementsByName("fdContTel11")[0].value = $.trim($('.css_tel_cont_area_day').eq(index).val());
                  window.opener.document.getElementsByName("fdContTel12")[0].value = $.trim($('.css_tel_cont_day').eq(index).val());
                  window.opener.document.getElementsByName("fdContTel13")[0].value = $.trim($('.css_tel_cont_ex_day').eq(index).val());
                  window.opener.document.getElementsByName("cMob1")[0].value = $.trim($('span.css_mobile').eq(index).text());
                  window.opener.document.getElementsByName("cEmail1")[0].value = $.trim($('span.css_email1').eq(index).text());
                  window.opener.document.getElementsByName("cZip")[0].value = $.trim($('.css_zip_cd_con').eq(index).val());
                  window.opener.document.getElementsByName("cAddress")[0].value = $.trim($('.css_addr_cont').eq(index).val());
	              window.opener.document.getElementsByName("custNo")[0].value = $.trim($('.css_cust_no').eq(index).val()); // 會員編號   
	              if( window.opener.document.getElementsByName("isB2E")[0] != undefined)
	              window.opener.document.getElementsByName("isB2E")[0].value = $.trim($('.css_isB2Emember').eq(index).val()); // 是否適用EC會員
	              window.close("searchCustID");
                """),format.raw/*56.17*/("""}"""),format.raw/*56.18*/("""); // end $(this).click();
                
              """),format.raw/*58.15*/("""}"""),format.raw/*58.16*/("""); // end $(':input[name="selTheCustInfo"]').each();
          
        """),format.raw/*60.9*/("""}"""),format.raw/*60.10*/("""); // end jQuery(document).ready();
      -->
    </script>
	<div class="row">
		<div class="col-xs-12 text-center">
			<table class="tb-2">
			<tr>
				<th></th>
				<th>身份證號碼</th>
				<th>姓名</th>
				<th>性別</th>
				<th>電話</th>
				<th>手機</th>
				<th>E-MAIL</th>
				<th>聯絡地址</th>
				<th>會員類別/國籍</th>
			</tr>
			"""),_display_(Seq[Any](/*77.5*/for(i <- 0 to memberList.size() - 1) yield /*77.41*/ {_display_(Seq[Any](format.raw/*77.43*/("""
			<tr>
				<td>"""),_display_(Seq[Any](/*79.10*/(i + 1))),format.raw/*79.17*/("""</td>
				<td class="text-center">
                    <span class='css_person_id' >"""),_display_(Seq[Any](/*81.51*/memberList(i)/*81.64*/.getPersonId())),format.raw/*81.78*/("""</span><br>
                    <input type="button" class="btn btn-success btn-xs" name="selTheCustInfo" value="確定">
                </td>
				<td><span class='css_name_chn' >"""),_display_(Seq[Any](/*84.38*/memberList(i)/*84.51*/.getNameChnFirst())),_display_(Seq[Any](/*84.70*/memberList(i)/*84.83*/.getNameChnLast())),format.raw/*84.100*/("""</span></td>
				<td><span class='css_sex_cd' >"""),_display_(Seq[Any](/*85.36*/memberList(i)/*85.49*/.getSex())),format.raw/*85.58*/("""</span></td>
				<td>
					"""),_display_(Seq[Any](/*87.7*/if(org.springframework.util.StringUtils.hasText(memberList(i).getTelAreaDay()))/*87.86*/ {_display_(Seq[Any](format.raw/*87.88*/("""
						"""),_display_(Seq[Any](/*88.8*/memberList(i)/*88.21*/.getTelAreaDay())),format.raw/*88.37*/(""" - 
					""")))})),format.raw/*89.7*/("""
					"""),_display_(Seq[Any](/*90.7*/memberList(i)/*90.20*/.getTelDay())),format.raw/*90.32*/("""
					"""),_display_(Seq[Any](/*91.7*/if(org.springframework.util.StringUtils.hasText(memberList(i).getTelExDay()))/*91.84*/ {_display_(Seq[Any](format.raw/*91.86*/("""
						#"""),_display_(Seq[Any](/*92.9*/memberList(i)/*92.22*/.getTelExDay())),format.raw/*92.36*/("""
					""")))})),format.raw/*93.7*/("""
					<!-- 電話回傳值 -->
					<input type='hidden' class='css_tel_cont_area_day' value='"""),_display_(Seq[Any](/*95.65*/memberList(i)/*95.78*/.getTelAreaDay())),format.raw/*95.94*/("""'   />
					<input type='hidden' class='css_tel_cont_day' value='"""),_display_(Seq[Any](/*96.60*/memberList(i)/*96.73*/.getTelDay())),format.raw/*96.85*/("""'   />
					<input type='hidden' class='css_tel_cont_ex_day' value='"""),_display_(Seq[Any](/*97.63*/memberList(i)/*97.76*/.getTelExDay())),format.raw/*97.90*/("""'   />
					<!-- 電話回傳值 -->
				</td>
				<td><span class='css_mobile' >"""),_display_(Seq[Any](/*100.36*/memberList(i)/*100.49*/.getTelMobile())),format.raw/*100.64*/("""</span></td>
				<td><span class='css_email1' >"""),_display_(Seq[Any](/*101.36*/memberList(i)/*101.49*/.getEmail1())),format.raw/*101.61*/("""</span></td>
				<td>
					"""),_display_(Seq[Any](/*103.7*/memberList(i)/*103.20*/.getZip())),format.raw/*103.29*/(""" """),_display_(Seq[Any](/*103.31*/memberList(i)/*103.44*/.getAddress())),format.raw/*103.57*/("""
					<!-- 地址回傳值 -->
					<input type='hidden' class='css_zip_cd_con' value='"""),_display_(Seq[Any](/*105.58*/memberList(i)/*105.71*/.getZip())),format.raw/*105.80*/("""'   />
					<input type='hidden' class='css_addr_cont' value='"""),_display_(Seq[Any](/*106.57*/memberList(i)/*106.70*/.getAddress())),format.raw/*106.83*/("""'   />
					<!-- 地址回傳值 -->
					
					<!-- CustNo回傳值 -->
					<input type='hidden' class='css_cust_no' value='"""),_display_(Seq[Any](/*110.55*/memberList(i)/*110.68*/.getCustNo())),format.raw/*110.80*/("""'   />
				</td>
				<td>
					"""),_display_(Seq[Any](/*113.7*/memberList(i)/*113.20*/.getCustType())),format.raw/*113.34*/("""<br>
					/"""),_display_(Seq[Any](/*114.8*/if(org.springframework.util.StringUtils.hasText(memberList(i).getNationality()))/*114.88*/ {_display_(Seq[Any](_display_(Seq[Any](/*114.91*/memberList(i)/*114.104*/.getNationality()))))}/*114.123*/else/*114.128*/{_display_(Seq[Any](format.raw/*114.129*/("""--""")))})),format.raw/*114.132*/("""
					
					<!-- 會員類別回傳值 -->
					<input type='hidden' class='css_isB2Emember' value='"""),_display_(Seq[Any](/*117.59*/if(memberList(i).getCustType().startsWith("企業會員"))/*117.109*/ {_display_(Seq[Any](format.raw/*117.111*/("""Y""")))}/*117.114*/else/*117.119*/{_display_(Seq[Any](format.raw/*117.120*/("""N""")))})),format.raw/*117.122*/("""'   />
				</td>
			</tr>
			""")))})),format.raw/*120.5*/("""
			</table>
			<br>
			<input type="button" class="btn btn-success btn-sm" value="取消" onclick="window.close();">
		</div>
	</div>
</body>
</html>"""))}
    }
    
    def render(memberList:List[pojo.Member]): play.api.templates.HtmlFormat.Appendable = apply(memberList)
    
    def f:((List[pojo.Member]) => play.api.templates.HtmlFormat.Appendable) = (memberList) => apply(memberList)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:33 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/order/customerSearchEC.scala.html
                    HASH: 51258263739d7977e20e5f79e6f4f67d1b2e2fdb
                    MATRIX: 802->1|927->32|964->35|1020->83|1059->85|1296->292|1742->702|1757->708|1816->745|1995->888|2010->894|2074->936|2138->964|2153->970|2215->1010|2296->1055|2311->1061|2372->1100|2476->1168|2491->1174|2543->1204|2724->1357|2753->1358|2850->1427|2879->1428|2949->1470|2978->1471|4613->3078|4642->3079|4730->3139|4759->3140|4860->3214|4889->3215|5259->3550|5311->3586|5351->3588|5407->3608|5436->3615|5559->3702|5581->3715|5617->3729|5833->3909|5855->3922|5904->3941|5926->3954|5966->3971|6051->4020|6073->4033|6104->4042|6169->4072|6257->4151|6297->4153|6341->4162|6363->4175|6401->4191|6443->4202|6486->4210|6508->4223|6542->4235|6585->4243|6671->4320|6711->4322|6756->4332|6778->4345|6814->4359|6853->4367|6976->4454|6998->4467|7036->4483|7139->4550|7161->4563|7195->4575|7301->4645|7323->4658|7359->4672|7471->4747|7494->4760|7532->4775|7618->4824|7641->4837|7676->4849|7742->4879|7765->4892|7797->4901|7836->4903|7859->4916|7895->4929|8012->5009|8035->5022|8067->5031|8168->5095|8191->5108|8227->5121|8379->5236|8402->5249|8437->5261|8508->5296|8531->5309|8568->5323|8617->5336|8707->5416|8757->5419|8781->5432|8814->5451|8829->5456|8870->5457|8907->5460|9034->5550|9095->5600|9137->5602|9160->5605|9175->5610|9216->5611|9252->5613|9317->5646
                    LINES: 26->1|29->1|30->2|30->2|30->2|37->9|51->23|51->23|51->23|55->27|55->27|55->27|56->28|56->28|56->28|59->31|59->31|59->31|62->34|62->34|62->34|68->40|68->40|69->41|69->41|70->42|70->42|84->56|84->56|86->58|86->58|88->60|88->60|105->77|105->77|105->77|107->79|107->79|109->81|109->81|109->81|112->84|112->84|112->84|112->84|112->84|113->85|113->85|113->85|115->87|115->87|115->87|116->88|116->88|116->88|117->89|118->90|118->90|118->90|119->91|119->91|119->91|120->92|120->92|120->92|121->93|123->95|123->95|123->95|124->96|124->96|124->96|125->97|125->97|125->97|128->100|128->100|128->100|129->101|129->101|129->101|131->103|131->103|131->103|131->103|131->103|131->103|133->105|133->105|133->105|134->106|134->106|134->106|138->110|138->110|138->110|141->113|141->113|141->113|142->114|142->114|142->114|142->114|142->114|142->114|142->114|142->114|145->117|145->117|145->117|145->117|145->117|145->117|145->117|148->120
                    -- GENERATED --
                */
            