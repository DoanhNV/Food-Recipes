
	$(document).ready(function() {
	
		
		$(".text-image").text("");

		$("#openfile").click(function() {
			alert("111");
			$(".file-upload").trigger('click');
		});
		
		

		$('#upload-file').on('change', function() {
			var filePath = $("#upload-file")[0].files[0];
			var reader = new FileReader();
			reader.readAsDataURL(filePath);
			$(".text-image").text("add");
			reader.onload = function(event) {
				$("#image-temp").attr("src", reader.result);
			};
			displayPostImage();
		});

		function displayPostImage() {
			$(".div-display-image").attr("style", "display:block");
		}

		function removeImage() {
			$(".div-display-image").attr("style", "display:none");
		}

		if ($(".text-image").text() != '') {
			displayPostImage();
		}

		$("#cancle-image").click(function() {
			removeImage();
		});
		
		$(".file-upload").attr("style","display:none !important");
	});