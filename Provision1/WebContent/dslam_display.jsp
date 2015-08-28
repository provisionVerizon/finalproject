<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="com.vz.disp.*,java.util.*,com.provisioning.javabeans.DSLAM"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.myButton1 {
	background-color:#44c767;
	-moz-border-radius:28px;
	-webkit-border-radius:28px;
	border-radius:28px;
	border:1px solid #18ab29;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:17px;
	padding:6px 6px;
	text-decoration:none;
	text-shadow:0px 1px 0px #2f6627;
}
.myButton1:hover {
	background-color:#5cbf2a;
}
.myButton1:active {
	position:relative;
	top:1px;
}

.myButton2 {
	-moz-box-shadow: 0px 1px 0px 0px #fff6af;
	-webkit-box-shadow: 0px 1px 0px 0px #fff6af;
	box-shadow: 0px 1px 0px 0px #fff6af;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #ffec64), color-stop(1, #ffab23));
	background:-moz-linear-gradient(top, #ffec64 5%, #ffab23 100%);
	background:-webkit-linear-gradient(top, #ffec64 5%, #ffab23 100%);
	background:-o-linear-gradient(top, #ffec64 5%, #ffab23 100%);
	background:-ms-linear-gradient(top, #ffec64 5%, #ffab23 100%);
	background:linear-gradient(to bottom, #ffec64 5%, #ffab23 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffec64', endColorstr='#ffab23',GradientType=0);
	background-color:#ffec64;
	-moz-border-radius:24px;
	-webkit-border-radius:24px;
	border-radius:24px;
	border:1px solid #ffaa22;
	display:inline-block;
	cursor:pointer;
	color:#333333;
	font-family:Arial;
	font-size:15px;
	font-weight:bold;
	padding:6px 6px;
	text-decoration:none;
	text-shadow:0px 1px 0px #ffee66;
}
.myButton2:hover {
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #ffab23), color-stop(1, #ffec64));
	background:-moz-linear-gradient(top, #ffab23 5%, #ffec64 100%);
	background:-webkit-linear-gradient(top, #ffab23 5%, #ffec64 100%);
	background:-o-linear-gradient(top, #ffab23 5%, #ffec64 100%);
	background:-ms-linear-gradient(top, #ffab23 5%, #ffec64 100%);
	background:linear-gradient(to bottom, #ffab23 5%, #ffec64 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffab23', endColorstr='#ffec64',GradientType=0);
	background-color:#ffab23;
}
.myButton2:active {
	position:relative;
	top:1px;
}

.myLabel1{
height: 75px;
width: 75px;

}
.mylabel2{
height: 200px;
width: 200px;

}

.myButton3 {
	-moz-box-shadow:inset 0px 39px 0px -24px #e67a73;
	-webkit-box-shadow:inset 0px 39px 0px -24px #e67a73;
	box-shadow:inset 0px 39px 0px -24px #e67a73;
	background-color:#e4685d;
	-moz-border-radius:20px;
	-webkit-border-radius:20px;
	border-radius:20px;
	border:1px solid #ffffff;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:15px;
	padding:6px 6px;
	text-decoration:none;
	text-shadow:0px 1px 0px #b23e35;
}
.myButton3:hover {
	background-color:#eb675e;
}
.myButton3:active {
	position:relative;
	top:1px;
}

.myButton {
	-moz-box-shadow:inset 0px -3px 7px 0px #29bbff;
	-webkit-box-shadow:inset 0px -3px 7px 0px #29bbff;
	box-shadow:inset 0px -3px 7px 0px #29bbff;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #2dabf9), color-stop(1, #0688fa));
	background:-moz-linear-gradient(top, #2dabf9 5%, #0688fa 100%);
	background:-webkit-linear-gradient(top, #2dabf9 5%, #0688fa 100%);
	background:-o-linear-gradient(top, #2dabf9 5%, #0688fa 100%);
	background:-ms-linear-gradient(top, #2dabf9 5%, #0688fa 100%);
	background:linear-gradient(to bottom, #2dabf9 5%, #0688fa 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#2dabf9', endColorstr='#0688fa',GradientType=0);
	background-color:#2dabf9;
	-moz-border-radius:20px;
	-webkit-border-radius:20px;
	border-radius:20px;
	border:2px solid #0b0e07;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:15px;
	padding:6px 6px;
	text-decoration:none;
	text-shadow:0px 1px 0px #263666;
}
.myButton4 {
	-moz-box-shadow: 0px 1px 0px 0px #f0f7fa;
	-webkit-box-shadow: 0px 1px 0px 0px #f0f7fa;
	box-shadow: 0px 1px 0px 0px #f0f7fa;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #33bdef), color-stop(1, #019ad2));
	background:-moz-linear-gradient(top, #33bdef 5%, #019ad2 100%);
	background:-webkit-linear-gradient(top, #33bdef 5%, #019ad2 100%);
	background:-o-linear-gradient(top, #33bdef 5%, #019ad2 100%);
	background:-ms-linear-gradient(top, #33bdef 5%, #019ad2 100%);
	background:linear-gradient(to bottom, #33bdef 5%, #019ad2 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#33bdef', endColorstr='#019ad2',GradientType=0);
	background-color:#33bdef;
	-moz-border-radius:20px;
	-webkit-border-radius:20px;
	border-radius:20px;
	border:1px solid #057fd0;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:15px;
	font-weight:bold;
	padding:6px 6px;
	text-decoration:none;
	text-shadow:0px -1px 0px #5b6178;
}
.myButton4:hover {
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #019ad2), color-stop(1, #33bdef));
	background:-moz-linear-gradient(top, #019ad2 5%, #33bdef 100%);
	background:-webkit-linear-gradient(top, #019ad2 5%, #33bdef 100%);
	background:-o-linear-gradient(top, #019ad2 5%, #33bdef 100%);
	background:-ms-linear-gradient(top, #019ad2 5%, #33bdef 100%);
	background:linear-gradient(to bottom, #019ad2 5%, #33bdef 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#019ad2', endColorstr='#33bdef',GradientType=0);
	background-color:#019ad2;
}
.myButton4:active {
	position:relative;
	top:1px;
}


</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


		<script>

		function func(i)
		{
			
		//alert(i);
		document.location.href = "SelectionServlet?i="+i;
		return false;	
		
		}

		</script>
		
</head>
<body bgcolor="white">
<center>


</center>


		<%
		
		//DSLAM d=(DSLAM)session.getAttribute("dslamNew"); 
		DSLAM d=(DSLAM)session.getAttribute("dslamNew");
		int a=d.getMAX_WIRELESS_CARD_CAPACITY();
		int b=d.getMAX_PON_CARD_CAPACITY();
		int c=d.getMAX_VES_CAPACITY();
		int e=d.getMAX_VOICE_CARD_CAPACITY();
		int f=d.getMAX_VIDEO_CARD_CAPACITY();
		int dataBuffer=d.getDc().getCAPACITY_ALLOCATED();
		
		String staA;
		
		
		HashMap hmAssigned=(HashMap)session.getAttribute("hmAssigned");
		HashMap hmActivated=(HashMap)session.getAttribute("hmActivated");
		HashMap hmNotWorking=(HashMap)session.getAttribute("hmNotWorking");
		%>
		
		<center>
		<h1>DSLAM NAME:<%= session.getAttribute("dname") %></h1>
		
		<h3><%=  session.getAttribute("Customer") %></h3>

	<table name="table" id="ont" bgcolor="black" border="10" bordercolor="black" cellpadding="2" cellspacing="2">
		<th colspan="11" bgcolor="white">Wireless</th>
	 	<tr bgcolor="#cdb5cd">

			<% for(int i=1;i<=a;i++) { 
				if((i%11)==0){%> 
				</tr>
				<tr  bgcolor="#cdb5cd">
				<%}
				staA=session.getAttribute("dname")+"W"+i;
				
				%> 
				<td><label class="myLabel1" > <dir>      </dir>
				<center> 
				
				<%   if(hmActivated.containsValue(staA)){ %>

				 <button class="myButton4" onclick="func('<%=session.getAttribute("dname") %>'+'W'+<%= i %>)"> </button></center>
				 <% }else   if(hmAssigned.containsValue(staA)){ %>
				 
				 
				 <center>
							<button class="myButton2"
								onclick="func('<%=session.getAttribute("dname") %>'+'W'+<%= i %>)">
							</button>
						</center> <%}else if(hmNotWorking.containsValue(staA)){ %>
				 
				  <center> 
				 <button class="myButton3" onclick="func('<%=session.getAttribute("dname") %>'+'W'+<%= i %>)"> </button></center>
				
				 
				 <%}else {%>
				  <center> 
				 <button class="myButton1" onclick="func('<%=session.getAttribute("dname") %>'+'W'+<%= i %>)"> </button></center>
				<%} %>
				</label>
				<dir></dir>
				</td>   
				<% } %>
	
		</tr>  
	
	
		
		
		<th colspan="11" bgcolor="white">VES</th>
		<tr bgcolor="#b0e0e6">

			<% for(int i=1;i<=c;i++) { 
				if((i%11)==0){%> 
				</tr>
				<tr  bgcolor="#b0e0e6">
				<%}
				staA=session.getAttribute("dname")+"VE"+i;%> 
				<td><label class="myLabel1" > <dir></dir>
				<center> <%   if(hmActivated.containsValue(staA)){ %>
				
				
				
				 <button class="myButton4" onclick="func('<%=session.getAttribute("dname") %>'+'VE'+<%= i %>)"> </button></center>
				 <% }else   if(hmAssigned.containsValue(staA)){ %>
				 
				 
				 <center> 
				 <button class="myButton2" onclick="func('<%=session.getAttribute("dname") %>'+'VE'+<%= i %>)"> </button></center>
				 <%}else if(hmNotWorking.containsValue(staA)){ %>
				 
				  <center> 
				 <button class="myButton3" onclick="func('<%=session.getAttribute("dname") %>'+'VE'+<%= i %>)"> </button></center>
				
				 
				 <%}else {%>
				  <center> 
				 <button class="myButton1" onclick="func('<%=session.getAttribute("dname") %>'+'VE'+<%= i %>)"> </button></center>
				<%} %></label>
				<dir></dir>
				</td>   
				<% } %>
	
		</tr>
		
		<tr bgcolor="#FFFFCC">
		<td colspan="11" height="75px"><center><b>Data capacity:<%= dataBuffer %></b></center></td></tr>
		
		<th colspan="11" bgcolor="white">Voice Ports</th>
		<tr bgcolor="#99FFCC">

			<% for(int i=1;i<=e;i++) { 
				if((i%11)==0){%> 
				</tr>
				<tr  bgcolor="#99FFCC">
				<%}%> 
				<td><label class="myLabel2" > <dir></dir>
				<center> <%  staA=session.getAttribute("dname")+"VO"+i+"P1"; if(hmActivated.containsValue(staA)){ %>
				
				
				
				 <button class="myButton4" onclick="func('<%=session.getAttribute("dname") %>'+'VO'+<%= i %>+'P1')"> </button></center>
				 <% }else   if(hmAssigned.containsValue(staA)){ %>
				 
				 
				 <center> 
				 <button class="myButton2" onclick="func('<%=session.getAttribute("dname") %>'+'VO'+<%= i %>+'P1')"> </button></center>
				 <%}else if(hmNotWorking.containsValue(staA)){ %>
				 
				  <center> 
				 <button class="myButton3" onclick="func('<%=session.getAttribute("dname") %>'+VO'+<%= i %>+'P1')"> </button></center>
				
				 
				 <%}else {%>
				  <center> 
				 <button class="myButton1" onclick="func('<%=session.getAttribute("dname") %>'+'VO'+<%= i %>+'P1')"> </button></center>
				<%} %><dir></dir>	<center> 
				
				<% staA=session.getAttribute("dname")+"VO"+i+"P2";  
				if(hmActivated.containsValue(staA)){ %>
				
				
				
				 <button class="myButton4" onclick="func('<%=session.getAttribute("dname") %>'+'VO'+<%= i %>+'P2')"> </button></center>
				 <% }else   if(hmAssigned.containsValue(staA)){ %>
				 
				 
				 <center> 
				 <button class="myButton2" onclick="func('<%=session.getAttribute("dname") %>'+'VO'+<%= i %>+'P2')"> </button></center>
				 <%}else if(hmNotWorking.containsValue(staA)){ %>
				 
				  <center> 
				 <button class="myButton3" onclick="func('<%=session.getAttribute("dname") %>'+'VO'+<%= i %>+'P2')"> </button></center>
				
				 
				 <%}else {%>
				  <center> 
				 <button class="myButton1" onclick="func('<%=session.getAttribute("dname") %>'+'VO'+<%= i %>+'P2')"> </button></center>
				<%} %>	<dir></dir><center>
				 <%  staA=session.getAttribute("dname")+"VO"+i+"P3";
				 if(hmActivated.containsValue(staA)){ %>
				
				
				
				 <button class="myButton4" onclick="func('<%=session.getAttribute("dname") %>'+'VO'+<%= i %>+'P3')"> </button></center>
				 <% }else   if(hmAssigned.containsValue(staA)){ %>
				 
				 
				 <center> 
				 <button class="myButton2" onclick="func('<%=session.getAttribute("dname") %>'+'VO'+<%= i %>+'P3')"> </button></center>
				 <%}else if(hmNotWorking.containsValue(staA)){ %>
				 
				  <center> 
				 <button class="myButton3" onclick="func('<%=session.getAttribute("dname") %>'+'VO'+<%= i %>+'P3')"> </button></center>
				
				 
				 <%}else {%>
				  <center> 
				 <button class="myButton1" onclick="func('<%=session.getAttribute("dname") %>'+'VO'+<%= i %>+'P3')"> </button></center>
				<%} %><dir></dir><center>
				
				 <% staA=session.getAttribute("dname")+"VO"+i+"P4";
				 if(hmActivated.containsValue(staA)){ %>
				
				
				
				 <button class="myButton4" onclick="func('<%=session.getAttribute("dname") %>'+'VO'+<%= i %>+'P4')"> </button></center>
				 <% }else   if(hmAssigned.containsValue(staA)){ %>
				 
				 
				 <center> 
				 <button class="myButton2" onclick="func('<%=session.getAttribute("dname") %>'+'VO'+<%= i %>+'P4')"> </button></center>
				 <%}else if(hmNotWorking.containsValue(staA)){ %>
				 
				  <center> 
				 <button class="myButton3" onclick="func('<%=session.getAttribute("dname") %>'+'VO'+<%= i %>+'P4')"> </button></center>
				
				 
				 <%}else {%>
				  <center> 
				 <button class="myButton1" onclick="func('<%=session.getAttribute("dname") %>'+'VO'+<%= i %>+'P4')"> </button></center>
				<%} %><dir></dir>
				</label>
				</td>   
				<% } %>
	
		</tr>
		<th colspan="11" bgcolor="white">Video ports</th>
		<tr bgcolor="#99CCFF">

			<% for(int i=1;i<=f;i++) { 
				if((i%11)==0){%> 
				</tr>
				<tr  bgcolor="#99CCFF">
				<%}  staA=session.getAttribute("dname")+"VP"+i;%> 
				<td><label class="myLabel1" > <dir></dir>
				<center><%   if(hmActivated.containsValue(staA)){ %>
				
				
				
				 <button class="myButton4" onclick="func('<%=session.getAttribute("dname") %>'+'VP'+<%= i %>)"> </button></center>
				 <% }else   if(hmAssigned.containsValue(staA)){ %>
				 
				 
				 <center> 
				 <button class="myButton2" onclick="func('<%=session.getAttribute("dname") %>'+'VP'+<%= i %>)"> </button></center>
				 <%}else if(hmNotWorking.containsValue(staA)){ %>
				 
				  <center> 
				 <button class="myButton3" onclick="func('<%=session.getAttribute("dname") %>'+'VP'+<%= i %>)"> </button></center>
				
				 
				 <%}else {%>
				  <center> 
				 <button class="myButton1" onclick="func('<%=session.getAttribute("dname") %>'+'VP'+<%= i %>)"> </button></center>
				<%} %>	</label>
				<dir></dir>
				</td>   
				<% } %>
	
		</tr>
		
		<th colspan="11" bgcolor="white">CMB</th>
	<tr bgcolor="#FFCCFF">

			<% for(int i=1;i<=b;i++) { 
				if((i%11)==0){%> 
				</tr>
				<tr  bgcolor="#FFCCFF">
				<%}          
				%> 
				<td><label class="myLabel1"> <dir></dir>
				<center> <% staA=session.getAttribute("dname")+"PO"+i+"P1";  if(hmActivated.containsValue(staA)){ %>
				
				
				
				 <button class="myButton4" onclick="func('<%=session.getAttribute("dname") %>'+'PO'+<%= i %>+'P1')"> </button></center>
				 <% }else   if(hmAssigned.containsValue(staA)){ %>
				 
				 
				 <center> 
				 <button class="myButton2" onclick="func('<%=session.getAttribute("dname") %>'+'PO'+<%= i %>+'P1')"> </button></center>
				 <%}else if(hmNotWorking.containsValue(staA)){ %>
				 
				  <center> 
				 <button class="myButton3" onclick="func('<%=session.getAttribute("dname") %>'+'PO'+<%= i %>+'P1')"> </button></center>
				
				 
				 <%}else {%>
				  <center> 
				 <button class="myButton1" onclick="func('<%=session.getAttribute("dname") %>'+'PO'+<%= i %>+'P1')"> </button></center>
				<%} %>	<dir></dir>
				<center> <% staA=session.getAttribute("dname")+"PO"+i+"P2";  if(hmActivated.containsValue(staA)){ %>
				
				
				
				 <button class="myButton4" onclick="func('<%=session.getAttribute("dname") %>'+'PO'+<%= i %>+'P2')"> </button></center>
				 <% }else   if(hmAssigned.containsValue(staA)){ %>
				 
				 
				 <center> 
				 <button class="myButton2" onclick="func('<%=session.getAttribute("dname") %>'+'PO'+<%= i %>+'P2')"> </button></center>
				 <%}else if(hmNotWorking.containsValue(staA)){ %>
				 
				  <center> 
				 <button class="myButton3" onclick="func('<%=session.getAttribute("dname") %>'+'PO'+<%= i %>+'P2')"> </button></center>
				
				 
				 <%}else {%>
				  <center> 
				 <button class="myButton1" onclick="func('<%=session.getAttribute("dname") %>'+'PO'+<%= i %>+'P2')"> </button></center>
				<%} %>	</label>
				<dir></dir>
				</td>   
				<% } %>
	
		</tr>
		
	</table>
	</center>

</body>
</html>