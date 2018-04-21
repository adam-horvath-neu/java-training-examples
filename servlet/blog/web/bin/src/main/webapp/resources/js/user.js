var list;
var results;

$(document).ready(function() {


		
		$('#result').hide();
		$(".loader").show();
		
		var size = new Number($('#number').val());
		$.get("${pageContext.request.contextPath}/UserServlet", function(res) {
			$('#result').html('');
			console.log(res);
			results = res.results;
			$.each(res.results, function(index, value) {

				$.get('${pageContext.request.contextPath}/content/content.html', function(template) {
				var t=	template.replace('user_name',value.name.first +' '+value.name.last);
				t=t.replace('img_url',value.picture.large);
				t=t.replace('city',value.location.postcode + ' ' + value.location.city);
				t=t.replace('street',value.location.street);
				t=t.replace('mail_addr',value.email);
				t=t.replace('number', index);
				
				$('#result').append(t);
				});
			});
			
			$(".loader").hide();
			$('#result').show();
		});


	
	
	
});

function handleClick(id) {
	//alert(id);
	$('#myModal').html('');
	$.get('${pageContext.request.contextPath}/content/modal.html', function(modal_res) {
		
		$.each(results, function(index, value) {
			if (index == id) {
				var t=	modal_res.replace('user_name',value.name.first +' '+value.name.last);
				t = t.replace('email', value.email);
				t = t.replace('username', value.login.username);
				t = t.replace('password', value.login.password);
				t = t.replace('phone', value.phone);
				t = t.replace('dob', value.dob);
				t = t.replace('gender', value.gender);
				t = t.replace('registered', value.registered);
				t = t.replace('cell', value.cell);
				t = t.replace('location', value.location.postcode + ' '
						+ value.location.city + ', '
						+ value.location.street);
				t = t.replace('img_url', value.picture.large);
				
				$('#myModal').append(t);
				return;
			}
			
		});
		
	});
}
