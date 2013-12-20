
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
object customerSearch extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[pojo.Customer],String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(customerList: List[pojo.Customer], index: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import eztravel.rest.util.common.DateUtils


Seq[Any](format.raw/*1.52*/("""
"""),_display_(Seq[Any](/*3.2*/if(null == customerList || customerList.size() <= 0)/*3.54*/ {_display_(Seq[Any](format.raw/*3.56*/("""
	<script type="text/javascript" language="javascript" >
		alert("查無此旅客基本資料");
        window.close("searchCustVSTriID");
    </script>
""")))})),format.raw/*8.2*/("""


<!DOCTYPE html>
<html lang="zh-TW">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="Kiki Liu">

	<title>旅客資料</title>

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
	<div id="customerIndex" data-customer='"""),format.raw/*38.41*/("""{"""),format.raw/*38.42*/(""""customerIndex":""""),_display_(Seq[Any](/*38.60*/index)),format.raw/*38.65*/("""""""),format.raw/*38.66*/("""}"""),format.raw/*38.67*/("""'></div>
	
	<script type="text/javascript" language="javascript" >
	
		// 資料回填
		jQuery(document).ready(function()"""),format.raw/*43.36*/("""{"""),format.raw/*43.37*/("""

			// customerIndex：傳入的第x位旅客、index：查詢出的第x位會員
			var customerIndex=$("#customerIndex").data("customer").customerIndex;  
			
			$(':input[name="selTheCustInfo"]').each(function(index)"""),format.raw/*48.59*/("""{"""),format.raw/*48.60*/("""
				$(this).click(function()"""),format.raw/*49.29*/("""{"""),format.raw/*49.30*/("""
					var birDTVal=$.trim($("#birthday").eq(index).text());
					//alert("birDTVal：" + birDTVal);
					
					if(birDTVal.length==8)"""),format.raw/*53.28*/("""{"""),format.raw/*53.29*/("""
						/* 票種檢核
						var yyyyVal=birDTVal.substring(0,4);
						var mmVal=birDTVal.substring(4,6);
						var ddVal=birDTVal.substring(6,8);
						
						if($.checkFriendBirthdayForCond2Type("1",yyyyVal,mmVal,ddVal))*/
							window.opener.document.getElementsByName("tChnNameF")[customerIndex].value = $.trim($("#nameChnFirst").eq(index).text());
							window.opener.document.getElementsByName("tChnNameL")[customerIndex].value = $.trim($("#nameChnLast").eq(index).text());
							window.opener.document.getElementsByName("tSex")[customerIndex].value = $.trim($("#sexEng").eq(index).val());
							window.opener.document.getElementsByName("tPersonId")[customerIndex].value = $.trim($("#personId").eq(index).text());
							var birthday_dtVal=$.trim($("#birthday").eq(index).text());
								
								if(birthday_dtVal != "" && birthday_dtVal.length )"""),format.raw/*66.59*/("""{"""),format.raw/*66.60*/("""
									window.opener.document.getElementsByName("tBirY")[customerIndex].value = birthday_dtVal.substring(0,4);
									window.opener.document.getElementsByName("tBirM")[customerIndex].value = birthday_dtVal.substring(4,6);
									window.opener.document.getElementsByName("tBirD")[customerIndex].value = birthday_dtVal.substring(6,8);
								"""),format.raw/*70.9*/("""}"""),format.raw/*70.10*/("""else"""),format.raw/*70.14*/("""{"""),format.raw/*70.15*/("""
									alert("出生日期不為8碼！！！");
									window.opener.document.getElementsByName("tBirY")[customerIndex].value = "";
									window.opener.document.getElementsByName("tBirM")[customerIndex].value = "";
									window.opener.document.getElementsByName("tBirD")[customerIndex].value = "";
								"""),format.raw/*75.9*/("""}"""),format.raw/*75.10*/("""
							
							window.close("searchCustVSTriID");
							
						/*else
							alert("旅客年齡不符該票種\n請您重新選擇其它旅客名單！！！");
						*/
						
					"""),format.raw/*83.6*/("""}"""),format.raw/*83.7*/("""else"""),format.raw/*83.11*/("""{"""),format.raw/*83.12*/("""
						alert("出生日期不為8碼！！！");
						window.opener.document.getElementsByName("tBirY")[0].value = "";
						window.opener.document.getElementsByName("tBirM")[0].value = "";
						window.opener.document.getElementsByName("tBirD")[0].value = "";
						window.close("searchCustVSTriID");
					"""),format.raw/*89.6*/("""}"""),format.raw/*89.7*/("""
				"""),format.raw/*90.5*/("""}"""),format.raw/*90.6*/("""); // end $(this).click(function()
			"""),format.raw/*91.4*/("""}"""),format.raw/*91.5*/("""); // end $':input[name="selTheCustInfo"]').each(function(index)

          
        """),format.raw/*94.9*/("""}"""),format.raw/*94.10*/("""); // end jQuery(document).ready();
    </script>
    
	<div class="row">
		<div class="col-xs-12 text-center">
			<table width="100%" class="tb-1">
			<tr>
				<th></th>
				<th>身份證號碼</th>
				<th>中文姓</th>
				<th>中文名</th>
				<th>英文姓</th>
				<th>英文名</th>
				<th>性別</th>
				<th>生日</th>
				<th>會員類別</th>
			</tr>
			"""),_display_(Seq[Any](/*111.5*/for(i <- 0 to customerList.size() - 1) yield /*111.43*/ {_display_(Seq[Any](format.raw/*111.45*/("""
			<tr>
				<td>"""),_display_(Seq[Any](/*113.10*/(i + 1))),format.raw/*113.17*/("""</td>
				<td id="personId">
                    """),_display_(Seq[Any](/*115.22*/customerList(i)/*115.37*/.getPersonId())),format.raw/*115.51*/("""<br>
                    <input type="button" class="btn btn-success btn-xs" name="selTheCustInfo" value="確定">
                </td>
				<td id="nameChnFirst">"""),_display_(Seq[Any](/*118.28*/customerList(i)/*118.43*/.getNameChnFirst())),format.raw/*118.61*/("""</td>
				<td id="nameChnLast">"""),_display_(Seq[Any](/*119.27*/customerList(i)/*119.42*/.getNameChnLast())),format.raw/*119.59*/("""</td>
				<td id="nameEngFirst">"""),_display_(Seq[Any](/*120.28*/customerList(i)/*120.43*/.getNameEngFirst())),format.raw/*120.61*/("""</td>
				<td id="nameEngLast">"""),_display_(Seq[Any](/*121.27*/customerList(i)/*121.42*/.getNameEngLast())),format.raw/*121.59*/("""</td>
				<td id="sex">"""),_display_(Seq[Any](/*122.19*/customerList(i)/*122.34*/.getSex().getName())),format.raw/*122.53*/("""</td>
				<input type="hidden" id="sexEng" value=""""),_display_(Seq[Any](/*123.46*/customerList(i)/*123.61*/.getSex())),format.raw/*123.70*/(""""/>
				<td id="birthday"><span>"""),_display_(Seq[Any](/*124.30*/DateUtils/*124.39*/.date2Str(customerList(i).getBirthday().getTime(), "yyyyMMdd"))),format.raw/*124.101*/("""</span></td>
				<td>
					"""),_display_(Seq[Any](/*126.7*/customerList(i)/*126.22*/.getCustType())),format.raw/*126.36*/("""<br>
					<!-- 會員類別回傳值 -->
					<input type='hidden' class='css_isB2Emember' value='"""),_display_(Seq[Any](/*128.59*/if(customerList(i).getCustType().startsWith("企業會員"))/*128.111*/ {_display_(Seq[Any](format.raw/*128.113*/("""Y""")))}/*128.116*/else/*128.121*/{_display_(Seq[Any](format.raw/*128.122*/("""N""")))})),format.raw/*128.124*/("""'   />
				</td>
			</tr>
			""")))})),format.raw/*131.5*/("""
			</table>
			<br>
			<input type="button" class="btn btn-success btn-sm" value="取消" onclick="window.close();">
		</div>
	</div>
</body>"""))}
    }
    
    def render(customerList:List[pojo.Customer],index:String): play.api.templates.HtmlFormat.Appendable = apply(customerList,index)
    
    def f:((List[pojo.Customer],String) => play.api.templates.HtmlFormat.Appendable) = (customerList,index) => apply(customerList,index)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:37 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/order/customerSearch.scala.html
                    HASH: bcf8c24f65135d1faade2afb462566723daf6e88
                    MATRIX: 809->1|997->51|1034->99|1094->151|1133->153|1305->295|1752->706|1767->712|1826->749|2005->892|2020->898|2084->940|2148->968|2163->974|2225->1014|2306->1059|2321->1065|2382->1104|2486->1172|2501->1178|2553->1208|2661->1288|2690->1289|2744->1307|2771->1312|2800->1313|2829->1314|2976->1433|3005->1434|3222->1623|3251->1624|3309->1654|3338->1655|3501->1790|3530->1791|4422->2655|4451->2656|4830->3008|4859->3009|4891->3013|4920->3014|5250->3317|5279->3318|5451->3463|5479->3464|5511->3468|5540->3469|5861->3763|5889->3764|5922->3770|5950->3771|6016->3810|6044->3811|6159->3899|6188->3900|6562->4238|6617->4276|6658->4278|6715->4298|6745->4305|6834->4357|6859->4372|6896->4386|7096->4549|7121->4564|7162->4582|7232->4615|7257->4630|7297->4647|7368->4681|7393->4696|7434->4714|7504->4747|7529->4762|7569->4779|7631->4804|7656->4819|7698->4838|7787->4890|7812->4905|7844->4914|7915->4948|7934->4957|8020->5019|8086->5049|8111->5064|8148->5078|8272->5165|8335->5217|8377->5219|8400->5222|8415->5227|8456->5228|8492->5230|8557->5263
                    LINES: 26->1|30->1|31->3|31->3|31->3|36->8|51->23|51->23|51->23|55->27|55->27|55->27|56->28|56->28|56->28|59->31|59->31|59->31|62->34|62->34|62->34|66->38|66->38|66->38|66->38|66->38|66->38|71->43|71->43|76->48|76->48|77->49|77->49|81->53|81->53|94->66|94->66|98->70|98->70|98->70|98->70|103->75|103->75|111->83|111->83|111->83|111->83|117->89|117->89|118->90|118->90|119->91|119->91|122->94|122->94|139->111|139->111|139->111|141->113|141->113|143->115|143->115|143->115|146->118|146->118|146->118|147->119|147->119|147->119|148->120|148->120|148->120|149->121|149->121|149->121|150->122|150->122|150->122|151->123|151->123|151->123|152->124|152->124|152->124|154->126|154->126|154->126|156->128|156->128|156->128|156->128|156->128|156->128|156->128|159->131
                    -- GENERATED --
                */
            