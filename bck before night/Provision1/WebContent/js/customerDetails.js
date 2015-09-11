
$(document)
		.ready(
				function() {

					// Stops the submit request
					$("#customerDetails").submit(function(e) {
						e.preventDefault();
					});

					$("#custSubmit")
							.click(
									function(e) {

										// get the form data and then serialize
										// that
										dataString = $("#customerDetails")
												.serialize();

										// get the form data using another
										// method
										var cust_id = $("input#custid").val();
										dataString = "custid=" + cust_id;

										// get the form data using another
										// method
										
										console.log("my data string = "
												+ dataString);
										// make the AJAX request, dataType is
										// set to json
										// meaning we are expecting JSON data in
										// response from the server
										$
												.ajax({
													type : "GET",
													url : "GetDetailsServlet",
													data : dataString,
													dataType : "json",

													// if received a response
													// from the server
													success : function(data,
															textStatus, jqXHR) {
														console.log("i m here");
														console.log(data);
														// var obj = JSON.parse(
														// data);
														/*
														 * json styr=
														 * {"cust_id":"15220",
														 * "type":"ves","first_name":"aditya","last_name":"bajpai","address_line1":"park
														 * street",
														 * "city":"kolkata",
														 * "pin_code":"140001","country":"india","phone_no":"950002000","voice":"no","data":"no","video":"no"}
														 */
														$("#content1").empty();
														$("#content1")
																.html(
																		"<b>Customer Details are </b>");
														$("#content1")
																.append(
																		"<table border=\" 2\"><caption>CUSTOMER DETAILS</caption><tr><td>CUSTOMER ID</td><td>TYPE</td><td>FIRST NAME</td><td>LAST NAME</td><td>ADDRESS </td><td>CITY </td><td>COUNTRY</td></tr>"
																				+ "<tr><td>"
																				+ data.cust_id
																				+ "</td>"
																				+ "<td>"
																				+ data.type
																				+ "</td>"
																				+ "<td>"
																				+ data.first_name
																				+ "</td>"
																				+ "<td>"
																				+ data.last_name
																				+ "</td>"
																				+ "<td>"
																				+ data.address_line1
																				+ "</td>"
																				+ "<td>"
																				+ data.city
																				+ "</td>"
																				+ "<td>"
																				+ data.country
																				+ "</td></tr></table><BR><BR>");
																					
							if(data.type=="ves")
								{
									
									$("#content2").empty();
									
														$("#content2")
														.append("<TABLE border=\"1px solid black\"><caption>CONNECTIONS</caption><TR><TD>DSLAM ID</TD><TD>VES CARD ID</TD><TD>VES CARD STATUS</TD><TR><TD>"+data.dslam_id+"</TD><TD>"+data.ves_card_id+"</TD><TD>"+data.ves_card_status+"</TD></TR></TABLE>");														
								}
								
								if(data.type=="cmb")
								{
									                    var ss1="";
									                    var ss2="";
									                    ss1+="<TABLE border=\"1px solid black\"><caption>CONNECTIONS</caption><TR>";
									                    ss2+="<tr>";

								                    	ss1+="<TD>DSLAM_ID</TD>";
								                    	ss2+="<TD>"+data.dslam_id+"</TD>";									                    	

								                    										                    	

								                    	ss1+="<TD>PON PORT ID</TD>";
								                    	ss2+="<TD>"+data.pon_port_id+"</TD>";									                    	

									                    if(data.voice!="no")
									                    	{
									                    	ss1+="<TD>VOICE CARD ID</TD>";
									                    	ss2+="<TD>"+data.voice_card_id+"</TD>";
									                    	ss1+="<TD>VOICE CARD STATUS</TD>";
									                    	ss2+="<TD>"+data.voice_card_status+"</TD>";	
									                    	}
									                    if(data.data!="no")
								                    	{
									                    	ss1+="<TD>DATA CARD ID</TD>";
									                    	ss2+="<TD>"+data.data_card_id+"</TD>";									                    	

									                    	ss1+="<TD>DATA CARD STATUS</TD>";
									                    	ss2+="<TD>"+data.data_port_status+"</TD>";									                    	

									                    	
								                    	}
									                    if(data.video!="no")
								                    	{
									                    	ss1+="<TD>VIDEO CARD ID</TD>";
									                    	ss2+="<TD>"+data.video_card_id+"</TD>";									                    	

									                    	ss1+="<TD>VIDEO CARD STATUS</TD>";
									                    	ss2+="<TD>"+data.video_card_status+"</TD>";									                    	

								                    	}
									                    ss1+="</tr>";
									                    ss2+"</tr></table>";
									                    $("#content2").empty();
														$("#content2").append(ss1+ss2);
								}
								if(data.type=="wireless")
								{
									$("#content2").empty();
									$("#content2")
									.append("<TABLE border=\"1px solid black\"><caption>CONNECTIONS</caption><TR><TD>DSLAM ID</TD><TD>VZW CARD ID</TD><TD>VZW CARD STATUS </TD></TR><TR><TD>"+data.dslam_id+"</TD><TD>"+data.wireless_card_id+"</TD><TD>"+data.wireless_card_status+"</TD></TR></TABLE>");														
			
								}
								

								},

													// If there was no resonse
													// from the server
													error : function(jqXHR,
															textStatus,
															errorThrown) {
														console
																.log("Something really bad happened "
																		+ textStatus);
														$("#content1")
																.html(
																		jqXHR.responseText
																				+ "   dcdddd");
													},

													// capture the request
													// before it was sent to
													// server
													beforeSend : function(
															jqXHR, settings) {
														// adding some Dummy
														// data to the request
														settings.data += "&dummyData=whatever";
														// disable the button
														// until we get the
														// response
														$('#custSubmit').attr(
																"disabled",
																true);
													},

													// this is called after the
													// response or error
													// functions are finsihed
													// so that we can take some
													// action
													complete : function(jqXHR,
															textStatus) {
														// enable the button
														$('#custSubmit').attr(
																"disabled",
																false);
													}

												});
									});

				});