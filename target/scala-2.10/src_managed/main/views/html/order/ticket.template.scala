
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
object ticket extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.2*/("""<div class="row">
		<div class="col-xs-12">
		<h3>
			<span class="tag-gn">+</span> 加購票券商品：
		</h3>
		</div>
	</div>
	
	<div class="row">
		<div class="col-xs-12">
        
<table width="100%" class="tb-1" style="margin-bottom:.5em">
<tr>
	<th colspan="4" >
		<img id="tktCheck0" height="11" alt="展開" style="margin-right:5px;" src="http://www.eztravel.com.tw/ss_static/images/icon_s_plus.gif" width="12" name="tktCheck0" onclick="data_display('tktProd0',this.name,'tktChoice0')"	/>
		南投日月潭遊湖船票 - 200 元起
		<input type="hidden" name="tktProdNo" value="TKAI000002328" />
		<input type="hidden" name="tktChoice0" value="0" />
        <a onclick="newWindow('4','TKAI000002328'); return false;" href="#">
		<img src="http://www.eztravel.com.tw/ss_static/images/listmore.gif" alt="詳細內容" width="11" height="12" hspace="5" border="0" />詳細說明
		</a>
		<input type="hidden" name="knowhow0" value="0" />
	</th>
</tr>

<tr id="tktProd0" name="tktProd0" style="display:none">
	<td> 
		<p style="text-indent:20px;" >
			<span class="showTktDesc" >成人券（二張）</span>
			<input type="checkbox" class="jqKnowShow" name="iknowhow0" onclick="setKnowhow(this);" />
			<a onclick="newWindow('4','TKAI000002328'); return false;" href="#" class="blue" ><u> 我已閱讀詳細說明</u></a>
		</p>
	</td>
	<td width="15%">市價：<s>600元</s></td>
	<td width="15%">價格：200元</td>
	<td width="15%">購買數量 
		<select name="fare" onchange="upd_choice('tktChoice0',this.selectedIndex)" >
			<option value="0" selected >0</option>
			<option value='1,00001,200,TKAI000002328'>1</option>
			<option value='2,00001,400,TKAI000002328'>2</option>
			<option value='3,00001,600,TKAI000002328'>3</option>
			<option value='4,00001,800,TKAI000002328'>4</option>
			<option value='5,00001,1000,TKAI000002328'>5</option>
			<option value='6,00001,1200,TKAI000002328'>6</option>
			<option value='7,00001,1400,TKAI000002328'>7</option>
			<option value='8,00001,1600,TKAI000002328'>8</option>
			<option value='9,00001,1800,TKAI000002328'>9</option>
			<option value='10,00001,2000,TKAI000002328'>10</option>
		</select>
	</td>
</tr>

<tr id="tktProd0" name="tktProd0" style="display:none">
	<td> 
		<p style="text-indent:20px;" >
			<span class="showTktDesc" >成人券（三張）</span>
			<input type="checkbox" class="jqKnowShow" name="iknowhow0" onclick="setKnowhow(this);" />
			<a onclick="newWindow('4','TKAI000002328'); return false;" href="#" class="blue" ><u> 我已閱讀詳細說明</u></a>
		</p>
	</td>
	<td width="15%">市價：<s>900元</s></td>
	<td width="15%">價格：300元</td>
	<td width="15%">購買數量 
		<select name="fare" onchange="upd_choice('tktChoice0',this.selectedIndex)" >
			<option value="0" selected >0</option>
			<option value='1,00002,300,TKAI000002328'>1</option>
			<option value='2,00002,600,TKAI000002328'>2</option>
			<option value='3,00002,900,TKAI000002328'>3</option>
			<option value='4,00002,1200,TKAI000002328'>4</option>
			<option value='5,00002,1500,TKAI000002328'>5</option>
			<option value='6,00002,1800,TKAI000002328'>6</option>
			<option value='7,00002,2100,TKAI000002328'>7</option>
			<option value='8,00002,2400,TKAI000002328'>8</option>
			<option value='9,00002,2700,TKAI000002328'>9</option>
			<option value='10,00002,3000,TKAI000002328'>10</option>
		</select>
	</td>
</tr>
</table>
        
        
        </div>
	</div>


<script type="text/javascript" language="javascript" >
//<!--

var imgPlus = 'http://www.eztravel.com.tw/ss_static/images/icon_s_plus.gif';
var imgMinus = 'http://www.eztravel.com.tw/ss_static/images/icon_s_minus2.gif';

function upd_choice(index,selValue)"""),format.raw/*92.36*/("""{"""),format.raw/*92.37*/("""
    if(selValue != 0)"""),format.raw/*93.22*/("""{"""),format.raw/*93.23*/("""
        window.document.getElementsByName(index)[0].value = 1;
    """),format.raw/*95.5*/("""}"""),format.raw/*95.6*/("""else"""),format.raw/*95.10*/("""{"""),format.raw/*95.11*/("""
        window.document.getElementsByName(index)[0].value = 0;
    """),format.raw/*97.5*/("""}"""),format.raw/*97.6*/("""
"""),format.raw/*98.1*/("""}"""),format.raw/*98.2*/(""" // end function upd_choice(index,selValue)

function data_display(index,chkbox_nm,choice_value)"""),format.raw/*100.52*/("""{"""),format.raw/*100.53*/("""
    var img = document.getElementById(chkbox_nm).src;
    var temp = index.substring(7,index.length);
    if(img == imgPlus)"""),format.raw/*103.23*/("""{"""),format.raw/*103.24*/(""" // 展開
        for(var i=0;i<window.document.getElementsByName(index).length;i++)"""),format.raw/*104.75*/("""{"""),format.raw/*104.76*/("""
            window.document.getElementsByName(index)[i].style.display = '';
        """),format.raw/*106.9*/("""}"""),format.raw/*106.10*/("""

        document.getElementById(chkbox_nm).src=imgMinus;
        document.getElementById(chkbox_nm).alt='關閉';
    """),format.raw/*110.5*/("""}"""),format.raw/*110.6*/("""else """),format.raw/*110.11*/("""{"""),format.raw/*110.12*/("""//關閉
        if(window.document.getElementsByName(choice_value)[0].value == 0)"""),format.raw/*111.74*/("""{"""),format.raw/*111.75*/("""
            for(var i=0;i<window.document.getElementsByName(index).length;i++)"""),format.raw/*112.79*/("""{"""),format.raw/*112.80*/("""
                window.document.getElementsByName(index)[i].style.display = 'none';
                document.getElementsByName('iknowhow'+temp)[i].checked=false;
              """),format.raw/*115.15*/("""}"""),format.raw/*115.16*/("""
              document.getElementsByName('knowhow'+temp)[0].value=0;
              document.getElementById(chkbox_nm).src=imgPlus;
              document.getElementById(chkbox_nm).alt='展開'
            """),format.raw/*119.13*/("""}"""),format.raw/*119.14*/(""" // end if(window.document.getElementsByName(choice_value)[0].value == 0)
          """),format.raw/*120.11*/("""}"""),format.raw/*120.12*/("""
        """),format.raw/*121.9*/("""}"""),format.raw/*121.10*/(""" // end function data_display(index,chkbox_nm,choice_value)
            
        function setTkt()"""),format.raw/*123.26*/("""{"""),format.raw/*123.27*/("""
          var order = window.document.order;
          for(i=0;i<window.document.order.length;i++)"""),format.raw/*125.54*/("""{"""),format.raw/*125.55*/("""
            if(order.elements[i].name.substring(0,7)=='knowhow'||order.elements[i].name.substring(0,9)=='tktChoice')"""),format.raw/*126.117*/("""{"""),format.raw/*126.118*/("""
              if(order.elements[i].value==1)"""),format.raw/*127.45*/("""{"""),format.raw/*127.46*/("""
                if(order.elements[i].name.substring(0,7)=='knowhow')"""),format.raw/*128.69*/("""{"""),format.raw/*128.70*/("""
                  var obj = order.elements[i].name.substring(7,order.elements[i].name.length);
                """),format.raw/*130.17*/("""}"""),format.raw/*130.18*/("""else if(order.elements[i].name.substring(0,9)=='tktChoice')"""),format.raw/*130.77*/("""{"""),format.raw/*130.78*/("""
                  var obj = order.elements[i].name.substring(9,order.elements[i].name.length);
                """),format.raw/*132.17*/("""}"""),format.raw/*132.18*/("""   
                data_display('tktProd'+obj,'tktCheck'+obj,'tktChoise'+obj);
                break;
              """),format.raw/*135.15*/("""}"""),format.raw/*135.16*/(""" // end if(order.elements[i].value==1)
            """),format.raw/*136.13*/("""}"""),format.raw/*136.14*/(""" // end if(order.elements[i].name.substring(0,7)=='knowhow'||order.elements[i].name.substring(0,9)=='tktChoice')
          """),format.raw/*137.11*/("""}"""),format.raw/*137.12*/(""" // end for(i=0;i<window.document.order.length;i++)
        """),format.raw/*138.9*/("""}"""),format.raw/*138.10*/(""" // end function setTkt()


        function open_tktData(url,arg)"""),format.raw/*141.39*/("""{"""),format.raw/*141.40*/("""
          window.open(url+arg,"desc","scrollbars=yes,resizable=yes,width=675,height=600");          
        """),format.raw/*143.9*/("""}"""),format.raw/*143.10*/(""" // end function open_tktData(url,arg)


        function setKnowhow(obj)"""),format.raw/*146.33*/("""{"""),format.raw/*146.34*/("""
          var objIndex = obj.name.substring(9,8);   
          var name = obj.name.substring(1);     
          var onTag = 0;
          for(var i=0; i<window.document.getElementsByName(obj.name).length; i++)"""),format.raw/*150.82*/("""{"""),format.raw/*150.83*/("""
            if(window.document.getElementsByName(obj.name)[i].checked)"""),format.raw/*151.71*/("""{"""),format.raw/*151.72*/("""
              onTag = 1;
            """),format.raw/*153.13*/("""}"""),format.raw/*153.14*/("""
          """),format.raw/*154.11*/("""}"""),format.raw/*154.12*/("""
          if(onTag == 0)"""),format.raw/*155.25*/("""{"""),format.raw/*155.26*/(""" window.document.getElementsByName(name)[0].value = 0; """),format.raw/*155.81*/("""}"""),format.raw/*155.82*/("""
          if(obj.checked)"""),format.raw/*156.26*/("""{"""),format.raw/*156.27*/("""
            window.document.getElementsByName(name)[0].value = "1";
          """),format.raw/*158.11*/("""}"""),format.raw/*158.12*/("""
        """),format.raw/*159.9*/("""}"""),format.raw/*159.10*/(""" // end function setKnowhow(obj)


      //---- 靜態超連結 ---- Start
        var win = null;
        function newWindow(mypage,prodNo) """),format.raw/*164.43*/("""{"""),format.raw/*164.44*/("""
            var winl = (screen.width-w)/2;
            var wint = (screen.height-h)/2;
            var gopage = "";
            var myname = "";
            var w = 0;
            var h = 0;
            var features = "scrollbars=yes,menubar=no,resizable=yes";

            if (winl < 0) winl = 0;
            if (wint < 0) wint = 0;

            if ( mypage == '1')
            """),format.raw/*177.13*/("""{"""),format.raw/*177.14*/("""
                gopage = "http://www.eztravel.com.tw/ezec/htl_tw/htltw_htl_detail.jsp?prod_no=" + prodNo;
                myname = "htlinfo";
                w = 670;h = 600;
            """),format.raw/*181.13*/("""}"""),format.raw/*181.14*/("""
            else if ( mypage == '2')
            """),format.raw/*183.13*/("""{"""),format.raw/*183.14*/("""
                gopage = "http://www.eztravel.com.tw/ezReview/reviewCollect/reviewViewList.do?prodNo=" + prodNo;
                myname = "review";
                w = 760;h = 600;
            """),format.raw/*187.13*/("""}"""),format.raw/*187.14*/("""
            else if ( mypage == '3')
            """),format.raw/*189.13*/("""{"""),format.raw/*189.14*/("""
                gopage = "http://www.eztravel.com.tw/ezec/htl_tw/htltwMapQuery.jsp?sh=" + prodNo;
                myname = "htlmap";
                w = 600;h = 455;
            """),format.raw/*193.13*/("""}"""),format.raw/*193.14*/("""
        	else if ( mypage == '4')
            """),format.raw/*195.13*/("""{"""),format.raw/*195.14*/("""
                gopage = "http://www.eztravel.com.tw/ezec/htl_tw/htltw_tktDesc.jsp?tktProdNo=" + prodNo;
                myname = "tktdesc";
                w = 675;h = 600;
            """),format.raw/*199.13*/("""}"""),format.raw/*199.14*/("""

            var settings = 'height=' + h + ',';
            settings += 'width=' + w + ',';
            settings += 'top=' + wint + ',';
            settings += 'left=' + winl + ',';
            settings += features;

            win = window.open(gopage,myname,settings);
            win.window.focus();
        """),format.raw/*209.9*/("""}"""),format.raw/*209.10*/("""
        //---- 靜態超連結 ---- End

//-->
</script>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:35 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/order/ticket.scala.html
                    HASH: 8ed25431527afe77fc2a37bf863a2fc6054fce15
                    MATRIX: 862->1|4512->3623|4541->3624|4592->3647|4621->3648|4718->3718|4746->3719|4778->3723|4807->3724|4904->3794|4932->3795|4961->3797|4989->3798|5116->3896|5146->3897|5303->4025|5333->4026|5444->4108|5474->4109|5589->4196|5619->4197|5767->4317|5796->4318|5830->4323|5860->4324|5968->4403|5998->4404|6107->4484|6137->4485|6346->4665|6376->4666|6611->4872|6641->4873|6755->4958|6785->4959|6823->4969|6853->4970|6982->5070|7012->5071|7142->5172|7172->5173|7320->5291|7351->5292|7426->5338|7456->5339|7555->5409|7585->5410|7728->5524|7758->5525|7846->5584|7876->5585|8019->5699|8049->5700|8198->5820|8228->5821|8309->5873|8339->5874|8492->5998|8522->5999|8611->6060|8641->6061|8739->6130|8769->6131|8909->6243|8939->6244|9044->6320|9074->6321|9316->6534|9346->6535|9447->6607|9477->6608|9546->6648|9576->6649|9617->6661|9647->6662|9702->6688|9732->6689|9816->6744|9846->6745|9902->6772|9932->6773|10042->6854|10072->6855|10110->6865|10140->6866|10305->7002|10335->7003|10757->7396|10787->7397|11008->7589|11038->7590|11119->7642|11149->7643|11376->7841|11406->7842|11487->7894|11517->7895|11729->8078|11759->8079|11837->8128|11867->8129|12087->8320|12117->8321|12470->8646|12500->8647
                    LINES: 29->1|120->92|120->92|121->93|121->93|123->95|123->95|123->95|123->95|125->97|125->97|126->98|126->98|128->100|128->100|131->103|131->103|132->104|132->104|134->106|134->106|138->110|138->110|138->110|138->110|139->111|139->111|140->112|140->112|143->115|143->115|147->119|147->119|148->120|148->120|149->121|149->121|151->123|151->123|153->125|153->125|154->126|154->126|155->127|155->127|156->128|156->128|158->130|158->130|158->130|158->130|160->132|160->132|163->135|163->135|164->136|164->136|165->137|165->137|166->138|166->138|169->141|169->141|171->143|171->143|174->146|174->146|178->150|178->150|179->151|179->151|181->153|181->153|182->154|182->154|183->155|183->155|183->155|183->155|184->156|184->156|186->158|186->158|187->159|187->159|192->164|192->164|205->177|205->177|209->181|209->181|211->183|211->183|215->187|215->187|217->189|217->189|221->193|221->193|223->195|223->195|227->199|227->199|237->209|237->209
                    -- GENERATED --
                */
            