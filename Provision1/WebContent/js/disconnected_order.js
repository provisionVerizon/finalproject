var arr;
var xmlhttp = new XMLHttpRequest();
var url = "GetDslamDetails";

xmlhttp.onreadystatechange = function() {
	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		myFunction(xmlhttp.responseText);
	}
}
xmlhttp.open("GET", url, true);
xmlhttp.send();
var t_id="";
var flag="";
var status;
function enablePort() {
    status="enable";
	flag="";
    if (document.getElementById('pon_port').checked) {
    	  flag="ponport";
    	}
    
    else if(document.getElementById('ont').checked) {
    	  flag="ont";
  	}
    t_id=document.getElementById('id').value;
    //alert(flag+"  "+t_id);
    sendUpdate();
}

function disablePort() {

	status="disable";
	flag="";
    if (document.getElementById('pon_port').checked) {
    	  flag="ponport";
    	}
    else if(document.getElementById('ont').checked) {
    	  flag="ont";
  	}
    t_id=document.getElementById('id').value;
   // alert(flag+"  "+t_id);
    sendUpdate();
	}

function sendUpdate()
{
   //alert(flag+"  "+t_id+" sbksbkjs");
	alert("port status "+status+" successfully");
   var str=flag+"_"+t_id+"*"+status;
	dataString = "name=" + str;
	//dataString += "id=" + t_id;

	$
			.ajax({
				type : "GET",
				url : "UpdatePort",
				data : dataString,
				dataType : "json",

				success : function(data,
						textStatus, jqXHR) {
				
				},

			
				error : function(jqXHR,
						textStatus,
						errorThrown) {
					console
							.log("Something really bad happened "
									+ textStatus);

				},

				beforeSend : function(
						jqXHR, settings) {
					// adding some Dummy
					// data to the request
					settings.data += "&dummyData=whatever";

				},

				complete : function(jqXHR,
						textStatus) {

				}

			});	
	 getPon();
}

function myFunction(response) {
	arr = JSON.parse(response);
	var i;

	$("#dSlam").empty();
	$("#dSlam").append("<option>Select DSLAM ID</option>");

	for (i = 0; i < arr.dslam.length; i++) {
		$("#dSlam").append(
				"<option value=\"" + arr.dslam[i].dslam_id + "\"> "
						+ arr.dslam[i].dslam_id + "</option>");
		// out2+= "<option >" +arr.pon_detail[i].pon_id +"</option>"
	}
	$("#dOnt").empty();
	$("#dOnt").append("<option>Select ONT ID</option>");
	for (i = 0; i < arr.ont.length; i++) {
		$("#dOnt").append(
				"<option value=\"" + arr.ont[i].ont_id + "\"> "
						+ arr.ont[i].ont_id + "</option>");
		// out2+= "<option >" +arr.pon_detail[i].pon_id +"</option>"
	}
  
	// out2+="</select>"

}
function getPon()
{
	var pon=document.getElementById('dSlampon').value;
	//alert(pon);
	dataString = "pon="+pon;
	$
			.ajax({
				type : "GET",
				url : "GetPonStatus",
				data : dataString,
				dataType : "json",

				// if received a response
				// from the server
				success : function(data,
						textStatus, jqXHR) {
					//alert(data.pon_port_id);
					$("#content5").empty();
					var ss = "<table border=\"1px solid black\"><tr><td>TYPE</td><td>ID</td><td>STATUS</td></tr>";
                    var i;
                    for(i=0;i<data.pon_port.length;i++)
                    	{
                    	ss += "<tr><td>"
                    		+data.pon_port[i].name
                    		+ "</td><td>"
							+ data.pon_port[i].id
							+ "</td><td>"
							+ data.pon_port[i].status
							+ "</td><tr>";
                    	}
						ss + "</table>"
					$("#content5").append(
							ss);
					// $("#content2").append(
					// data.result);
					// $("#content2").append(
					// "</h3>");
				},

				// If there was no resonse
				// from the server
				error : function(jqXHR,
						textStatus,
						errorThrown) {
					console
							.log("Something really bad happened "
									+ textStatus);

				},

				// capture the request
				// before it was sent to
				// server
				beforeSend : function(
						jqXHR, settings) {
					// adding some Dummy
					// data to the request
					settings.data += "&dummyData=whatever";

				},

				// this is called after the
				// response or error
				// functions are finsihed
				// so that we can take some
				// action
				complete : function(jqXHR,
						textStatus) {

				}

			});
}
$(document)
		.ready(
				function() {
					
					$("#dSlam")
							.change(
									function() {
										//alert("Handler for dSlam called.");
										var value = $("#dSlam").val();
										//alert("Handler for dSlam called."
										//		+ value);
										var i;
										$("#dSlampon").empty();
										$("#dSlampon")
												.append(
														"<option>SELECT PON PORT ID</option>");

										for (i = 0; i < arr.pon_detail.length; i++) {
											if (arr.pon_detail[i].dslam_id == value)

												$("#dSlampon")
														.append(
																"<option value=\""
																		+ arr.pon_detail[i].pon_id
																		+ "\"> "
																		+ arr.pon_detail[i].pon_id
																		+ "</option>");
										}
									});

					$("#dOnt")
							.change(
									function() {
										dataString = "name=aditya";
										$
												.ajax({
													type : "GET",
													url : "GetOntDetail",
													data : dataString,
													dataType : "json",

													// if received a response
													// from the server
													success : function(data,
															textStatus, jqXHR) {
														//alert(data.pon_port_id);
														$("#content3").empty();
														var ss = "<table border=\"1px solid black\">";

														ss += "<tr><td>ONT PORT</td><td>"
																+ data.ont_id
																+ "</td><td>"
																+ data.ont_port_status
																+ "</td><td><button name=\"bOnt\" id=\"bOnt\" >";
														if (data.ont_port_status == "running")
															ss += "DISABLE";
														else if (data.ont_port_status == "disable")
															ss += "RUNNING";
														ss += "</button></td></tr>";
														ss + "</table>"
														$("#content3").append(
																ss);
														// $("#content2").append(
														// data.result);
														// $("#content2").append(
														// "</h3>");
													},

													// If there was no resonse
													// from the server
													error : function(jqXHR,
															textStatus,
															errorThrown) {
														console
																.log("Something really bad happened "
																		+ textStatus);

													},

													// capture the request
													// before it was sent to
													// server
													beforeSend : function(
															jqXHR, settings) {
														// adding some Dummy
														// data to the request
														settings.data += "&dummyData=whatever";

													},

													// this is called after the
													// response or error
													// functions are finsihed
													// so that we can take some
													// action
													complete : function(jqXHR,
															textStatus) {

													}

												});
										
										
									});
					

//					$("#dOnt").on("click", "button.bOnt", function(){
//					    alert("Aaa");
//					});
					
					
					$("#dSlampon")
							.change(
									function() {

										getPon();

									});
				});
     
/*
 * 
 * 
 * 
 */