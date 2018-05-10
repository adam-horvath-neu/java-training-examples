$(document).ready(function() {
	getComments();
});

function getComments() {

	jQuery.ajax({
		url : "/webApp/blog",
		dataType : "json",
		data : {
			'blogId' : $("#blogId").val()
		},
		success : function(data) {

			

			jQuery.ajax({
				url : "/webApp/comment",
				dataType : "json",
				data : {
					'blogId' : $("#blogId").val()
				},
				type : "GET",
				success : function(data) {
					$('#comments').html('');
					$(data).each(
							function(index, value) {
								console.log(value);
								jQuery.ajax({
									url : "resources/template/comment.html",
									success : function(template) {
										template = template.replace('#text',
												value.comment);
										$('#comments').append(template);
									}
								});
							});
				},

			});

		},

	});

}

function addComment() {

	jQuery.ajax({
		url : "/webApp/comment",
		type : "POST",
		data : {
			'comment' : $("#comment").val(),
			'blogId' : $("#blogId").val()
		},
		success : function(data) {
			console.log(data);
			jQuery.ajax({
				url : "resources/template/comment.html",
				success : function(template) {
					template = template.replace('#text', $("#comment").val());
					$('#comments').append(template);
				}
			});

		}
	});
}