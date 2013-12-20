	function setAllAddress(){

      var cStateVal=document.order.cState.value;                         
      var cCityNameVal=document.order.cCityName.value.substr(0,2);       
      var cCityOptsVal="";                                               
      var cAddressVal=document.order.cAddress.value;

      
      if(  ( cStateVal == "新北市" && cAddressVal.indexOf("台北縣")!=-1 )
         ||( cStateVal == "台中市" && cAddressVal.indexOf("台中縣")!=-1 )
         ||( cStateVal == "台南市" && cAddressVal.indexOf("台南縣")!=-1 )
         ||( cStateVal == "高雄市" && cAddressVal.indexOf("高雄縣")!=-1 ) ){
         document.order.cAddress.value="";
      }

      setCity(document.order,document.order.cState.selectedIndex,'C');

      if(cCityNameVal != ''){
        for(i = 0 ; i < document.order.cCity.length ; i++) {
          cCityOptsVal=document.order.cCity.options[i].text.substr(0,2);  
          if(cCityOptsVal == cCityNameVal){
            document.order.cCity.options[i].selected=true;
          }
        }
      }
    } // end function setAllAddress()
    
  


    

    
    function setHSRAllAddress(){

      var mStateVal=document.order.mState.value;                         
      var mCityNameVal=document.order.mCityName.value.substr(0,2);       
      var mCityOptsVal="";                                               
      var mAddressVal=document.order.mAddress.value;

      
      if(  ( mStateVal == "新北市" && mAddressVal.indexOf("台北縣")!=-1 )
         ||( mStateVal == "台中市" && mAddressVal.indexOf("台中縣")!=-1 )
         ||( mStateVal == "台南市" && mAddressVal.indexOf("台南縣")!=-1 )
         ||( mStateVal == "高雄市" && mAddressVal.indexOf("高雄縣")!=-1 ) ){
         document.order.mAddress.value="";
      }
      

      setCity(document.order,document.order.mState.selectedIndex,'M');

      if(mCityNameVal != ''){  
        for(i = 0 ; i < document.order.mCity.length ; i++) {
          mCityOptsVal=document.order.mCity.options[i].text.substr(0,2);  
          if(mCityOptsVal == mCityNameVal){
            document.order.mCity.options[i].selected=true;
          }
        }
      }
      
    } // end function setAllAddress()
    
    


    
    function invSetPost(){  
      setCity(window.document.order,window.document.order.iState.selectedIndex,'I');
      if(window.document.order.iCityName.value != '' ) {
        for(i = 0 ; i < window.document.order.iCity.length ; i++) {
          if( window.document.order.iCity.options[i].text == window.document.order.iCityName.value) {
            window.document.order.iCity.options[i].selected=true;
          }
        }
      }
    } // end function invSetPost()
    



    
    
    function setCity(formName,j,_type){
        
      if(j==0) { // default category item 

        a=new Array(); 
        a[1]=new Option("請選擇",""); 

      }else if(j==1) { // 基隆市 category items --> 

        a=new Array(); 
        a[1]=new Option("請選擇",""); 
        a[2]=new Option("仁愛區","仁愛區200"); 
        a[3]=new Option("信義區","信義區201"); 
        a[4]=new Option("中正區","中正區202"); 
        a[5]=new Option("中山區","中山區203"); 
        a[6]=new Option("安樂區","安樂區204"); 
        a[7]=new Option("暖暖區","暖暖區205"); 
        a[8]=new Option("七堵區","七堵區206"); 

      }else if(j==2) { // 台北市 category items

        a=new Array(); 
        a[1]=new Option("請選擇",""); 
        a[2]=new Option("中正區","中正區100"); 
        a[3]=new Option("大同區","大同區103"); 
        a[4]=new Option("中山區","中山區104"); 
        a[5]=new Option("松山區","松山區105"); 
        a[6]=new Option("大安區","大安區106"); 
        a[7]=new Option("萬華區","萬華區108"); 
        a[8]=new Option("信義區","信義區110"); 
        a[9]=new Option("士林區","士林區111"); 
        a[10]=new Option("北投區","北投區112"); 
        a[11]=new Option("內湖區","內湖區114"); 
        a[12]=new Option ("南港區","南港區115"); 
        a[13]=new Option ("文山區","文山區116"); 

      }else if(j==3) { // 新北市 category items 

        a=new Array(); 
        a[1]=new Option("請選擇",""); 
        a[2]=new Option("萬里區","萬里區207"); 
        a[3]=new Option("金山區","金山區208"); 
        a[4]=new Option("板橋區","板橋區220"); 
        a[5]=new Option("汐止區","汐止區221"); 
        a[6]=new Option("深坑區","深坑區222"); 
        a[7]=new Option("石碇區","石碇區223"); 
        a[8]=new Option("瑞芳區","瑞芳區224"); 
        a[9]=new Option("平溪區","平溪區226"); 
        a[10]=new Option("雙溪區","雙溪區227");
        a[11]=new Option("貢寮區","貢寮區228");
        a[12]=new Option("新店區","新店區231");
        a[13]=new Option("坪林區","坪林區232");
        a[14]=new Option("烏來區","烏來區233");
        a[15]=new Option("永和區","永和區234");
        a[16]=new Option("中和區","中和區235");
        a[17]=new Option("土城區","土城區236"); 
        a[18]=new Option("三峽區","三峽區237"); 
        a[19]=new Option("樹林區","樹林區238"); 
        a[20]=new Option("鶯歌區","鶯歌區239"); 
        a[21]=new Option("三重區","三重區241"); 
        a[22]=new Option("新莊區","新莊區242"); 
        a[23]=new Option("泰山區","泰山區243"); 
        a[24]=new Option("林口區","林口區244"); 
        a[25]=new Option("蘆洲區","蘆洲區247"); 
        a[26]=new Option("五股區","五股區248"); 
        a[27]=new Option("八里區","八里區249"); 
        a[28]=new Option("淡水區","淡水區251"); 
        a[29]=new Option("三芝區","三芝區252"); 
        a[30]=new Option("石門區","石門區253"); 

      }else if(j==4) { // 桃園縣 category items 
        
        a=new Array(); 
        a[1]=new Option("請選擇",""); 
        a[2]=new Option("中壢市","中壢市320");
        a[3]=new Option("平鎮市","平鎮市324");
        a[4]=new Option("龍潭鄉","龍潭鄉325");
        a[5]=new Option("楊梅鎮","楊梅鎮326");
        a[6]=new Option("新屋鄉","新屋鄉327");
        a[7]=new Option("觀音鄉","觀音鄉328");
        a[8]=new Option("桃園市","桃園市330");
        a[9]=new Option("龜山鄉","龜山鄉333");
        a[10]=new Option("八德市","八德市334");
        a[11]=new Option("大溪鎮","大溪鎮335");
        a[12]=new Option("復興鄉","復興鄉336");
        a[13]=new Option("大園鄉","大園鄉337");
        a[14]=new Option("蘆竹鄉","蘆竹鄉338");

      }else if(j==5) { // 新竹市 category items 
        
        a=new Array(); 
        a[1]=new Option("請選擇",""); 
        a[2]=new Option("東區","東區300"); 
        a[3]=new Option("北區","北區300"); 
        a[4]=new Option("香山區","香山區300"); 

      }else if(j==6) { // 新竹縣 category items 
        
        a=new Array(); 
        a[1]=new Option("請選擇",""); 
        a[2]=new Option("竹北市","竹北市302");
        a[3]=new Option("湖口鄉","湖口鄉303");
        a[4]=new Option("新豐鄉","新豐鄉304");
        a[5]=new Option("新埔鎮","新埔鎮305");
        a[6]=new Option("關西鎮","關西鎮306");
        a[7]=new Option("芎林鄉","芎林鄉307");
        a[8]=new Option("寶山鄉","寶山鄉308");
        a[9]=new Option("竹東鎮","竹東鎮310");
        a[10]=new Option("五峰鄉","五峰鄉311");
        a[11]=new Option("橫山鄉","橫山鄉312");
        a[12]=new Option("尖石鄉","尖石鄉313");
        a[13]=new Option("北埔鄉","北埔鄉314");
        a[14]=new Option("峨眉鄉","峨眉鄉315");

      }else if(j==7) { // 苗栗縣 category items 
        
        a=new Array(); 
        a[1]=new Option("請選擇",""); 
        a[2]=new Option("竹南鎮","竹南鎮350");
        a[3]=new Option("頭份鎮","頭份鎮351");
        a[4]=new Option("三灣鄉","三灣鄉352");
        a[5]=new Option("南庄鄉","南庄鄉353");
        a[6]=new Option("獅潭鄉","獅潭鄉354");
        a[7]=new Option("後龍鎮","後龍鎮356");
        a[8]=new Option("通宵鎮","通宵鎮357");
        a[9]=new Option("苑裡鎮","苑裡鎮358");
        a[10]=new Option("苗栗市","苗栗市360");
        a[11]=new Option("造橋鄉","造橋鄉361");
        a[12]=new Option("頭屋鄉","頭屋鄉362");
        a[13]=new Option("公館鄉","公館鄉363");
        a[14]=new Option("大湖鄉","大湖鄉364");
        a[15]=new Option("泰安鄉","泰安鄉365");
        a[16]=new Option("銅鑼鄉","銅鑼鄉366");
        a[17]=new Option("三義鄉","三義鄉367");
        a[18]=new Option("西湖鄉","西湖鄉368");
        a[19]=new Option("卓蘭鎮","卓蘭鎮369");

      }else if(j==8) { // 台中市 category items 

        a=new Array(); 
        a[1]=new Option("請選擇",""); 
        a[2]=new Option("中區","中區400");
        a[3]=new Option("東區","東區401");
        a[4]=new Option("南區","南區402");
        a[5]=new Option("西區","西區403");
        a[6]=new Option("北區","北區404");
        a[7]=new Option("北屯區","北屯區406"); 
        a[8]=new Option("西屯區","西屯區407"); 
        a[9]=new Option("南屯區","南屯區408"); 
        a[10]=new Option("太平區","太平區411");
        a[11]=new Option("大里區","大里區412");
        a[12]=new Option("霧峰區","霧峰區413");
        a[13]=new Option("烏日區","烏日區414");
        a[14]=new Option("豐原區","豐原區420");
        a[15]=new Option("后里區","后里區421");
        a[16]=new Option("石岡區","石岡區422");
        a[17]=new Option("東勢區","東勢區423");
        a[18]=new Option("和平區","和平區424");
        a[19]=new Option("新社區","新社區426");
        a[20]=new Option("潭子區","潭子區427");
        a[21]=new Option("大雅區","大雅區428");
        a[22]=new Option("神岡區","神岡區429");
        a[23]=new Option("大肚區","大肚區432");
        a[24]=new Option("沙鹿區","沙鹿區433");
        a[25]=new Option("龍井區","龍井區434");
        a[26]=new Option("梧棲區","梧棲區435");
        a[27]=new Option("清水區","清水區436");
        a[28]=new Option("大甲區","大甲區437");
        a[29]=new Option("外埔區","外埔區438");
        a[30]=new Option("大安區","大安區439");

      }else if(j==9) { // 彰化縣 category items 

        a=new Array(); 
        a[1]=new Option("請選擇",""); 
        a[2]=new Option("彰化市","彰化市500");
        a[3]=new Option("芬園鄉","芬園鄉502");
        a[4]=new Option("花壇鄉","花壇鄉503");
        a[5]=new Option("秀水鄉","秀水鄉504");
        a[6]=new Option("鹿港鎮","鹿港鎮505");
        a[7]=new Option("福興鄉","福興鄉506");
        a[8]=new Option("線西鄉","線西鄉507");
        a[9]=new Option("和美鎮","和美鎮508");
        a[10]=new Option("伸港鄉","伸港鄉509");
        a[11]=new Option("員林鎮","員林鎮510");
        a[12]=new Option("社頭鄉","社頭鄉511");
        a[13]=new Option("永靖鄉","永靖鄉512");
        a[14]=new Option("埔心鄉","埔心鄉513");
        a[15]=new Option("溪湖鎮","溪湖鎮514");
        a[16]=new Option("大村鄉","大村鄉515");
        a[17]=new Option("埔鹽鄉","埔鹽鄉516");
        a[18]=new Option("田中鎮","田中鎮520");
        a[19]=new Option("北斗鎮","北斗鎮521");
        a[20]=new Option("田尾鄉","田尾鄉522");
        a[21]=new Option("埤頭鄉","埤頭鄉523");
        a[22]=new Option("溪州鄉","溪州鄉524");
        a[23]=new Option("竹塘鄉","竹塘鄉525");
        a[24]=new Option("二林鎮","二林鎮526");
        a[25]=new Option("大城鄉","大城鄉527");
        a[26]=new Option("芳苑鄉","芳苑鄉528");
        a[27]=new Option("二水鄉","二水鄉600");

      }else if(j==10) { // 南投縣 category items
     
        a=new Array(); 
        a[1]=new Option("請選擇",""); 
        a[2]=new Option("南投市","南投市540");
        a[3]=new Option("中寮鄉","中寮鄉541");
        a[4]=new Option("草屯鎮","草屯鎮542");
        a[5]=new Option("國姓鄉","國姓鄉544");
        a[6]=new Option("埔里鎮","埔里鎮545");
        a[7]=new Option("仁愛鄉","仁愛鄉546");
        a[8]=new Option("名間鄉","名間鄉551");
        a[9]=new Option("集集鎮","集集鎮552");
        a[10]=new Option("水里鄉","水里鄉553");
        a[11]=new Option("魚池鄉","魚池鄉555");
        a[12]=new Option("信義鄉","信義鄉556");
        a[13]=new Option("竹山鎮","竹山鎮557");
        a[14]=new Option("鹿谷鄉","鹿谷鄉558");

      }else if(j==11) { // 雲林縣 category items 
        
        a=new Array(); 
        a[1]=new Option("請選擇",""); 
        a[2]=new Option("斗南鎮","斗南鎮630");
        a[3]=new Option("大埤鄉","大埤鄉631");
        a[4]=new Option("虎尾鎮","虎尾鎮632");
        a[5]=new Option("土庫鎮","土庫鎮633");
        a[6]=new Option("褒忠鄉","褒忠鄉634");
        a[7]=new Option("東勢鄉","東勢鄉635");
        a[8]=new Option("台西鄉","台西鄉636");
        a[9]=new Option("崙背鄉","崙背鄉637");
        a[10]=new Option("麥寮鄉","麥寮鄉638");
        a[11]=new Option("斗六市","斗六市640");
        a[12]=new Option("林內鄉","林內鄉643");
        a[13]=new Option("古坑鄉","古坑鄉646");
        a[14]=new Option("薊桐鄉","薊桐鄉647");
        a[15]=new Option("西螺鎮","西螺鎮648");
        a[16]=new Option("二崙鄉","二崙鄉649");
        a[17]=new Option("北港鎮","北港鎮651");
        a[18]=new Option("水林鄉","水林鄉652");
        a[19]=new Option("口湖鄉","口湖鄉653");
        a[20]=new Option("四湖鄉","四湖鄉654");
        a[21]=new Option("元長鄉","元長鄉655");

      }else if(j==12) { // 嘉義市 category items 

        a=new Array();  
        a[1]=new Option("請選擇",""); 
        a[2]=new Option("東區","東區600"); 
        a[3]=new Option("西區","西區600"); 

      }else if(j==13) { // 嘉義縣 category items 

        a=new Array(); 
        a[1]=new Option("請選擇",""); 
        a[2]=new Option("番路鄉","番路鄉602");
        a[3]=new Option("梅山鄉","梅山鄉603");
        a[4]=new Option("竹崎鄉","竹崎鄉604");
        a[5]=new Option("阿里山鄉","阿里山鄉605");
        a[6]=new Option("中埔鄉","中埔鄉606");
        a[7]=new Option("大埔鄉","大埔鄉607");
        a[8]=new Option("水上鄉","水上鄉608");
        a[9]=new Option("鹿草鄉","鹿草鄉611");
        a[10]=new Option("太保市","太保市612");
        a[11]=new Option("朴子市","朴子市613");
        a[12]=new Option("東石鄉","東石鄉614");
        a[13]=new Option("六腳鄉","六腳鄉615");
        a[14]=new Option("新港鄉","新港鄉616");
        a[15]=new Option("民雄鄉","民雄鄉621");
        a[16]=new Option("大林鎮","大林鎮622");
        a[17]=new Option("溪口鄉","溪口鄉623");
        a[18]=new Option("義竹鄉","義竹鄉624");
        a[19]=new Option("布袋鎮","布袋鎮625");

      }else if(j==14) { // 台南市 category items 

        a=new Array(); 
        a[1]=new Option("請選擇",""); 
        a[2]=new Option("中西區","中西區700");
        a[3]=new Option("東區","東區701");
        a[4]=new Option("南區","南區702");
        a[5]=new Option("北區","北區704");
        a[6]=new Option("安平區","安平區708"); 
        a[7]=new Option("安南區","安南區709"); 
        a[8]=new Option("永康區","永康區710");
        a[9]=new Option("歸仁區","歸仁區711");
        a[10]=new Option("新化區","新化區712");
        a[11]=new Option("左鎮區","左鎮區713");
        a[12]=new Option("玉井區","玉井區714");
        a[13]=new Option("楠西區","楠西區715");
        a[14]=new Option("南化區","南化區716");
        a[15]=new Option("仁德區","仁德區717");
        a[16]=new Option("關廟區","關廟區718");
        a[17]=new Option("龍崎區","龍崎區719");
        a[18]=new Option("官田區","官田區720");
        a[19]=new Option("麻豆區","麻豆區721");
        a[20]=new Option("佳里區","佳里區722");
        a[21]=new Option("西港區","西港區723");
        a[22]=new Option("七股區","七股區724");
        a[23]=new Option("將軍區","將軍區725");
        a[24]=new Option("學甲區","學甲區726");
        a[25]=new Option("北門區","北門區727");
        a[26]=new Option("新營區","新營區730");
        a[27]=new Option("後壁區","後壁區731");
        a[28]=new Option("白河區","白河區732");
        a[29]=new Option("東山區","東山區733");
        a[30]=new Option("六甲區","六甲區734");
        a[31]=new Option("下營區","下營區735");
        a[32]=new Option("柳營區","柳營區736");
        a[33]=new Option("鹽水區","鹽水區737");
        a[34]=new Option("善化區","善化區741");
        a[35]=new Option("大內區","大內區742");
        a[36]=new Option("山上區","山上區743");
        a[37]=new Option("新市區","新市區744");
        a[38]=new Option("安定區","安定區745");


      }else if(j==15) { // 高雄市 category items 

        a=new Array(); 
        a[1]=new Option("請選擇",""); 
        a[2]=new Option("新興區","新興區800"); 
        a[3]=new Option("前金區","前金區801"); 
        a[4]=new Option("苓雅區","苓雅區802"); 
        a[5]=new Option("鹽埕區","鹽埕區803"); 
        a[6]=new Option("鼓山區","鼓山區804"); 
        a[7]=new Option("旗津區","旗津區805"); 
        a[8]=new Option("前鎮區","前鎮區806"); 
        a[9]=new Option("三民區","三民區807"); 
        a[10]=new Option("楠梓區","楠梓區811"); 
        a[11]=new Option("小港區","小港區812"); 
        a[12]=new Option("左營區","左營區813"); 
        a[13]=new Option("仁武區","仁武區814");
        a[14]=new Option("大社區","大社區815");
        a[15]=new Option("東沙群島","東沙群島817");
        a[16]=new Option("南沙群島","南沙群島819");
        a[17]=new Option("岡山區","岡山區820");
        a[18]=new Option("路竹區","路竹區821");
        a[19]=new Option("阿蓮區","阿蓮區822");
        a[20]=new Option("田寮區","田寮區823");
        a[21]=new Option("燕巢區","燕巢區824");
        a[22]=new Option("橋頭區","橋頭區825");
        a[23]=new Option("梓官區","梓官區826");
        a[24]=new Option("彌陀區","彌陀區827");
        a[25]=new Option("永安區","永安區828");
        a[26]=new Option("湖內區","湖內區829");
        a[27]=new Option("鳳山區","鳳山區830");
        a[28]=new Option("大寮區","大寮區831");
        a[29]=new Option("林園區","林園區832");
        a[30]=new Option("鳥松區","鳥松區833");
        a[31]=new Option("大樹區","大樹區840");
        a[32]=new Option("旗山區","旗山區842");
        a[33]=new Option("美濃區","美濃區843");
        a[34]=new Option("六龜區","六龜區844");
        a[35]=new Option("內門區","內門區845");
        a[36]=new Option("杉林區","杉林區846");
        a[37]=new Option("甲仙區","甲仙區847");
        a[38]=new Option("桃源區","桃源區848");
        a[39]=new Option("那瑪夏區","那瑪夏區849");
        a[40]=new Option("茂林區","茂林區851");
        a[41]=new Option("茄萣區","茄萣區852");


      }else if(j==16) { // 屏東縣 category items 

        a=new Array(); 
        a[1]=new Option("請選擇",""); 
        a[2]=new Option("屏東市","屏東市900");
        a[3]=new Option("三地門鄉","三地門鄉901");
        a[4]=new Option("霧台鄉","霧台鄉902");
        a[5]=new Option("瑪家鄉","瑪家鄉903");
        a[6]=new Option("九如鄉","九如鄉904");
        a[7]=new Option("里港鄉","里港鄉905");
        a[8]=new Option("高樹鄉","高樹鄉906");
        a[9]=new Option("鹽埔鄉","鹽埔鄉907");
        a[10]=new Option("長治鄉","長治鄉908");
        a[11]=new Option("麟洛鄉","麟洛鄉909");
        a[12]=new Option("竹田鄉","竹田鄉911");
        a[13]=new Option("內埔鄉","內埔鄉912");
        a[14]=new Option("萬丹鄉","萬丹鄉913");
        a[15]=new Option("潮州鎮","潮州鎮920");
        a[16]=new Option("泰武鄉","泰武鄉921");
        a[17]=new Option("來義鄉","來義鄉922");
        a[18]=new Option("萬巒鄉","萬巒鄉923");
        a[19]=new Option("崁頂鄉","崁頂鄉924");
        a[20]=new Option("新埤鄉","新埤鄉925");
        a[21]=new Option("南州鄉","南州鄉926");
        a[22]=new Option("林邊鄉","林邊鄉927");
        a[23]=new Option("東港鎮","東港鎮928");
        a[24]=new Option("琉球鄉","琉球鄉929");
        a[25]=new Option("佳冬鄉","佳冬鄉931");
        a[26]=new Option("新園鄉","新園鄉932");
        a[27]=new Option("枋寮鄉","枋寮鄉940");
        a[28]=new Option("枋山鄉","枋山鄉941");
        a[29]=new Option("春日鄉","春日鄉942");
        a[30]=new Option("獅子鄉","獅子鄉943");
        a[31]=new Option("車城鄉","車城鄉944");
        a[32]=new Option("牡丹鄉","牡丹鄉945");
        a[33]=new Option("恆春鎮","恆春鎮946");
        a[34]=new Option("滿州鄉","滿州鄉947");

      }else if(j==17) { // 台東縣 category items
     
        a=new Array(); 
        a[1]=new Option("請選擇",""); 
        a[2]=new Option("台東市","臺東市950");
        a[3]=new Option("綠島鄉","綠島鄉951");
        a[4]=new Option("蘭嶼鄉","蘭嶼鄉952");
        a[5]=new Option("延平鄉","延平鄉953");
        a[6]=new Option("卑南鄉","卑南鄉954");
        a[7]=new Option("鹿野鄉","鹿野鄉955");
        a[8]=new Option("關山鎮","關山鎮956");
        a[9]=new Option("海端鄉","海端鄉957");
        a[10]=new Option("池上鄉","池上鄉958");
        a[11]=new Option("東河鄉","東河鄉959");
        a[12]=new Option("成功鎮","成功鎮961");
        a[13]=new Option("長濱鄉","長濱鄉962");
        a[14]=new Option("太麻里鄉","太麻里鄉963");
        a[15]=new Option("金峰鄉","金峰鄉964");
        a[16]=new Option("大武鄉","大武鄉965");
        a[17]=new Option("達仁鄉","達仁鄉966");

      }else if(j==18) { // 花蓮縣 category items 

        a=new Array(); 
        a[1]=new Option("請選擇",""); 
        a[2]=new Option("花蓮市","花蓮市970");
        a[3]=new Option("新城鄉","新城鄉971");
        a[4]=new Option("秀林鄉","秀林鄉972");
        a[5]=new Option("吉安鄉","吉安鄉973");
        a[6]=new Option("壽豐鄉","壽豐鄉974");
        a[7]=new Option("鳳林鎮","鳳林鎮975");
        a[8]=new Option("光復鄉","光復鄉976");
        a[9]=new Option("豐濱鄉","豐濱鄉977");
        a[10]=new Option("瑞穗鄉","瑞穗鄉978");
        a[11]=new Option("萬榮鄉","萬榮鄉979");
        a[12]=new Option("玉里鎮","玉里鎮981");
        a[13]=new Option("卓溪鄉","卓溪鄉982");
        a[14]=new Option("富里鄉","富里鄉983");

      }else if(j==19) { // 宜蘭縣 category items 

        a=new Array(); 
        a[1]=new Option("請選擇",""); 
        a[2]=new Option("宜蘭市","宜蘭市260");
        a[3]=new Option("頭城鎮","頭城鎮261");
        a[4]=new Option("礁溪鄉","礁溪鄉262");
        a[5]=new Option("狀圍鄉","狀圍鄉263");
        a[6]=new Option("員山鄉","員山鄉264");
        a[7]=new Option("羅東鎮","羅東鎮265");
        a[8]=new Option("三星鄉","三星鄉266");
        a[9]=new Option("大同鄉","大同鄉267");
        a[10]=new Option("五結鄉","五結鄉268");
        a[11]=new Option("冬山鄉","冬山鄉269");
        a[12]=new Option("蘇澳鄉","蘇澳鄉270");
        a[13]=new Option("南澳鄉","南澳鄉272");
        a[14]=new Option("釣魚台","釣魚台290");

      }else if(j==20) { // 澎湖縣 category items 

        a=new Array(); 
        a[1]=new Option("請選擇",""); 
        a[2]=new Option("馬公市","馬公市880");
        a[3]=new Option("西嶼鄉","西嶼鄉881");
        a[4]=new Option("望安鄉","望安鄉882");
        a[5]=new Option("七美鄉","七美鄉883");
        a[6]=new Option("白沙鄉","白沙鄉884");
        a[7]=new Option("湖西鄉","湖西鄉885");

      }else if(j==21) { // 金門縣 category items 

        a=new Array(); 
        a[1]=new Option("請選擇",""); 
        a[2]=new Option("金沙鎮","金沙鎮890");
        a[3]=new Option("金湖鎮","金湖鎮891");
        a[4]=new Option("金寧鄉","金寧鄉892");
        a[5]=new Option("金城鎮","金城鎮893");
        a[6]=new Option("烈嶼鄉","烈嶼鄉894");
        a[7]=new Option("烏坵鄉","烏坵鄉896");

      }else if(j==22) { // 連江縣 category items 
        
        a=new Array(); 
        a[1]=new Option("請選擇",""); 
        a[2]=new Option("南竿鄉","南竿鄉209");
        a[3]=new Option("北竿鄉","北竿鄉210");
        a[4]=new Option("莒光鄉","莒光鄉211");
        a[5]=new Option("東引鄉","東引鄉212");

      }else if(j>=23) { // 其他地區 category items 

        a=new Array(); 
        a[1]=new Option("-----","other---");

      }else{}



      // **********************************************************
      // 處理依城市的選項出現相關的鄉鎮市區的資料(開始)
      if(_type == 'MEMBER'){           
        for(var i=formName.city1.length-1;i>0;i--){
          formName.city1.options[i]=null; 
        }
        for(var i=1;i<a.length;i++){
           if (a[i].value == "other---") {
                formName.city1.options[i-1]= a[i];
                formName.city1.disabled = true;
                formName.zip_cd.disabled = true;
                formName.address.disabled = true;
           }else{
                formName.city1.disabled = false;
                formName.zip_cd.disabled = false;
                formName.address.disabled = false;
                formName.city1.options[i-1]= a[i];
           }
        } 
        if(a.length == 2 ) {
          setZip_cd(formName.city1.options[0].value,'ADD_MEMBER');
        }  
        formName.city1.options[0].selected=true; 
        formName.address.value =  formName.state.options[j].value ;
        if(formName.address.value == "NO") formName.address.value = " ";
      }else if(_type == 'C'){          
        for(var i=formName.cCity.length-1;i>0;i--){
          formName.cCity.options[i]=null; 
        }
        for(var i=1;i<a.length;i++) { 
          formName.cCity.options[i-1]= a[i];
        } 
        if(a.length == 2 ) {
          setZip_cd(formName.cCity.options[0].value, 'C');
        }
        formName.cCity.options[0].selected=true; 
      }else if(_type == 'M'){          
        for(var i=formName.mCity.length-1;i>0;i--){
          formName.mCity.options[i]=null; 
        }
        for(var i=1;i<a.length;i++) { 
          formName.mCity.options[i-1]= a[i];
        } 
        if(a.length == 2 ) {
          setZip_cd(formName.mCity.options[0].value, 'M');
        }
        formName.cCity.options[0].selected=true; 
      }else if(_type == 'I'){          
        for (var i=formName.iCity.length-1;i>0;i--){
          formName.iCity.options[i]=null;
        } 
        for (var i=1;i<a.length;i++){
          formName.iCity.options[i-1]= a[i]; 
        }
        if(a.length == 2 ) {
          setZip_cd(formName.iCity.options[0].value, 'I');
        }
        formName.iCity.options[0].selected=true; 
      }else if(_type == 'P'){          
        for(var i=formName.pCity.length-1;i>0;i--){
          formName.pCity.options[i]=null;
        } 
        for (var i=1;i<a.length;i++){
          formName.pCity.options[i-1]= a[i];
        } 
        if(a.length == 2 ) {
           setZip_cd(formName.pCity.options[0].value, 'P');
        }
        formName.pCity.options[0].selected=true; 
      }else{                           
        for(var i=formName.gZone.length-1;i>0;i--){ 
          formName.gZone.options[i]=null; 
        }
        for(var i=1;i<a.length;i++){ 
          formName.gZone.options[i-1]= a[i];
        }
        if(a.length == 2 ) {
          setZip_cd(formName.gZone.options[0].value,'G');
        }
        formName.gZone.options[0].selected=true; 
      }
      // **********************************************************
      // 處理依城市的選項出現相關的鄉鎮市區的資料(結束)

    } // end function setCity(formName,j,_type)
    



    
    
    function setZip_cd(str,_type2){
      var city_cd=str.substr(0,str.length-3);              
      var zip_cd=str.substr(str.length-3,str.length);      

      if(_type2 == 'MEMBER' || _type2 =='ADD_MEMBER'){          
        document.forms[0].address.value=document.forms[0].state.options[document.forms[0].state.selectedIndex].value+city_cd;
        document.forms[0].address.value=document.forms[0].address.value.replace(new RegExp("NO","gm"),"");
        document.forms[0].city.value = city_cd ;
        document.forms[0].zip_cd.value=zip_cd;
      }else if (_type2 == 'C') {       
        document.order.cCityName.value = city_cd ;
        document.order.cZip.value=zip_cd;
        document.order.cAddress.value=document.order.cState.value+city_cd;
        document.order.cAddress.value=document.order.cAddress.value.replace(new RegExp("NO","gm"),"");
      }else if (_type2 == 'M') {       
        document.order.mCityName.value = city_cd ;
        document.order.mZip.value=zip_cd;
        document.order.mAddress.value=document.order.mState.value+city_cd;
        document.order.mAddress.value=document.order.mAddress.value.replace(new RegExp("NO","gm"),"");
      }else if (_type2 == 'I') {       
        document.order.iCityName.value = city_cd ;
        document.order.iZip.value=zip_cd;
        document.order.iAddress.value=document.order.iState.value+city_cd;
        document.order.iAddress.value=document.order.iAddress.value.replace(new RegExp("NO","gm"),"");
      } else if(_type2 == 'P') {       
        document.order.pCityName.value = city_cd ;
        document.order.pZip.value=zip_cd;
      }else {                           
        document.order.gCityName.value = city_cd ;
        document.order.post_zip.value=zip_cd;
      }

    } // end function setZip_cd(str,_type2)