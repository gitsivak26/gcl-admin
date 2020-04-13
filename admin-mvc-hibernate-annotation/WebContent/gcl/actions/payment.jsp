<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Payment</title>
		
		<style>
			body {background-color: green;}
			
			h3{
				text-align: -moz-center;
				padding-top: 25px;
				font-size: 30px;
			}
			
			.main-section{
				max-width: 1000px;
				width: 100%;
				padding-left: 175px;
			}
			
			.content-section{
				background-color: greenyellow;
			}
			
			.info-section{
				position: absolute;
				height: 25px;
				background-color: green;
				padding: 5px 412px;
			}
			
			.name-section{
				color: white;
				font-size: 20px;
				font-weight: bold;
				padding-left: 35px;
			}
			
			.btn{
				background-color: chartreuse;
				font-weight: bold;
				padding: 10px 70px;
				font-size: 20px;
			}
			
			.action-btn{
				background-color: chartreuse;
				font-weight: bold;
				padding: 5px 50px;
				font-size: 16px;
			}
			
			.application-section{
				padding: 70px 20px;
			}
			
			.app-details{
				line-height: 2;
			}
		</style>
		
		<script type="text/javascript" src="//js.usagreencardlottery.org/scripts/payment/cryptodelegate.js"></script>
		
		<script type="text/javascript">
		
		function umHashGeneration() {
			   var hostName = window.location.hostname;
			   var pin = 6666;
			   var convertedAmount;
			   var hash;
			   var command = $("#UMcommand").val();
			   var custom = $("#UMcustom1").val().slice(8,-1);
			   var invoice = $("#orderNumber").val() + "-" + custom;
			         convertedAmount = Math.round($("#amount").val());
			         $("#UMinvoice").val(invoice);
			         $("#UMamount").val(convertedAmount);
			         $("#UMline1cost").val(convertedAmount);                                        
			         hash = Crypto.SHA1(command + ":" + pin + ":" + convertedAmount + ":" + invoice + ":" + custom);
			         $("#UMhash").val("s/" + custom + "/" + hash + "/y");
			}


		
		</script>
		
	</head>
	<body>
	
		<div class="main-section">
			<div class="content-section">
			
				<h3>Application / Payment Actions</h3>
				
				<div class="info-section">
					<div class="name-section">
						<a href="/admin" style="color: white;">Home</a> |  
						<a href="logout" style="color: white;">SignOut</a>
					</div>
				</div>
				
				<p>This customer is not paid. So please do the payment.</p>
				
				<!-- USAEPAY - API URL (https://help.usaepay.info/developer/transaction-api/) -->
				
				<form id="submitPayment" name="submitPayment" action="https://sandbox.usaepay.com/gate.php" method="post">
				
					<input type="hidden" id="amount" name="amount" value="133.00" />
					<input type="hidden" id="product" name="product" value="GCL Form" />
					
					
					<input type="hidden" name="UMinvoice" id="UMinvoice" value="6192583"/>
					<input type="hidden" name="UMcommand" id="UMcommand" value="sale"/>
					<input type="hidden" name="UMcurrency" value="840"/>
					<input type="hidden" name="UMip" id="UMip" value="10.0.102.33"/>
					<input type="hidden" name="UMcustemail" value="sivak@dcis.net"/>
					<input type="hidden" name="UMamount" id="UMamount" value="133.00"/>
					<input type="hidden" name="UMredir" value="/paymentResponse"/>
					<input type="hidden" name="UMexpir" id="UMexpir" value="0921"/>
					<input type="hidden" name="UMline1qty" value="1"/>
					<input type="hidden" name="UMechofields" value="yes"/>
					<input type="hidden" name="UMbillzip" id="UMbillzip" value="12345"/>
					<input type="hidden" name="UMline1sku" value="GCL Form"/>
					<input type="hidden" name="UMline1name" value="GCL Form"/>
					<input type="hidden" name="UMkey" id="UMkey" value="_8pgmy3l6s7PID9XayJUWlHJY53nemi2"/>
					<input type="hidden" name="UMhash" id="UMhash" value="${umHash}"/>
					<input type="hidden" name="UMname" id="UMname" value="test dcis"/>
					<input type="hidden" name="UMcard" id="UMcard" value="4000200011112222"/>
					<input type="hidden" name="UMcvv2" id="UMcvv2" value="000"/>
					
					<input type="hidden" name="UMmaskedCardNum" id="UMmaskedCardNum" value=""/>
					<input type="hidden" name="UMline1cost" id="UMline1cost" value=""/>
					<input type="hidden" name="UMcustom1" id="UMcustom1" value="${paymentPostTime}"/>
					
                                
					<!-- <input type="hidden" name="UMkey" id="UMkey" value="${processorKey}"/>
					<input type="hidden" name="UMhash" id="UMhash" value="${umHash}"/>
					<input type="hidden" name="UMip" id="UMip" value="${umIp}"/>
					<input type="hidden" name="UMstreet" id="UMstreet"/>
					<input type="hidden" name="UMcurrency" value="840"/>
					<input type="hidden" name="UMcustemail" value="${custEmailId}"/>
					<input type="hidden" name="UMinvoice" id="UMinvoice" value="${custId}"/>
					<input type="hidden" name="UMredir" value="${postBackURL}"/>
					<input type="hidden" name="UMexpir" id="UMexpir"/>
					<input type="hidden" name="UMcommand" id="UMcommand" value="${transactionType}"/>
					<input type="hidden" name="UMamount" id="UMamount" value=""/>
					<input type="hidden" name="UMcustom1" id="UMcustom1" value="${paymentPostTime}"/>
					<input type="hidden" name="UMname" id="UMname"/>
					<input type="hidden" name="UMbillfname" id="UMbillfname"/>
					<input type="hidden" name="UMbilllname" id="UMbilllname"/>
					<input type="hidden" name="UMline1sku" value="${applicationName}"/>
					<input type="hidden" name="UMline1name" value="${applicationName}"/>
					<input type="hidden" name="UMline1description" value="${applicationName}Form"/>
					<input type="hidden" name="UMline1cost" id="UMline1cost" value=""/>
					<input type="hidden" name="UMline1qty" value="1"/>
					<input type="hidden" name="UMechofields" value="yes"/>
					<input type="hidden" name="UMbillzip" id="UMbillzip" />
					<input type="hidden" name="UMbillstate" id="UMbillstate"/>
					<input type="hidden" name="UMcard" id="UMcard"/>
					<input type="hidden" name="UMmaskedCardNum" id="UMmaskedCardNum"/>
					<input type="hidden" name="UMcvv2" id="UMcvv2" value=""/> -->
				
					<label>Select Card Type:</label>
						<input type="radio" value="Credit Card" id="cardType" name="cardType" />
						<label>Credit Card</label>
						
					<label>Card Number</label>
						<input type="text" id="cardnumber" name="cardnumber" value="" />
						
					<label>Card Name</label>
						<input type="text" id="cardName" name="cardName" value="" />
						
					<label>Expiration Month</label>
						<input type="text" id="month" name="month" value="" />
						
					<label>Expiration Year</label>
						<input type="text" id="year" name="year" value="" />
						
					<label>Security Code</label>
						<input type="text" id="code" name="code" value="" />
						
					<label>Postal Code</label>
						<input type="text" id="postalCode" name="postalCode" value="" />
						
						
					<input type="submit" value="Pay Now" name="payNow" id=""payNow />					
					
				</form>
				
				
			</div>
		</div>

	</body>
</html>