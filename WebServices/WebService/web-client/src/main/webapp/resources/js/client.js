var RestApi = {
	rootUri : "http://localhost:8080/service/resources",
	UserApi : function() {
		var path0 = RestApi.rootUri;
		return {
			Users : function() {
				var path1 = path0 + "/users";
				return {
					Save : function() {
						var path2 = path1 + "/save";
						return {
							// Required: Entity: requestEntity Optional:
							putJson : function(requestEntity) {
								return $.ajax(path2, {
									type : "PUT",
									contentType : "application/json",
									data : JSON.stringify(requestEntity),
									headers : {
										Accept : "application/json"
									}

								});

							}
							// Required: Entity: requestEntity Optional:
							,
							putXml : function(requestEntity) {
								return $.ajax(path2, {
									type : "PUT",
									contentType : "application/xml",
									data : requestEntity,
									headers : {
										Accept : "application/xml"
									}

								});

							}

						};

					},
					Username : function(username) {
						var path2 = path1 + "/{username}";
						path2 = path2.replace(/\{username.*?\}/, username);
						return {
							// Required: Optional:
							getAsJson : function() {
								return $.ajax(path2, {
									type : "GET",
									headers : {
										Accept : "application/json"
									}

								});

							}
							// Required: Optional:
							,
							getAsXml : function() {
								return $.ajax(path2, {
									type : "GET",
									headers : {
										Accept : "application/xml"
									}

								});

							}

						};

					},
					List : function() {
						var path2 = path1 + "/list";
						return {
							// Required: Optional:
							getAsJson : function() {
								return $.ajax(path2, {
									type : "GET",
									headers : {
										Accept : "application/json"
									}

								});

							}

						};

					},
					Id : function() {
						var path2 = path1 + "/id";
						return {
							// Required: Optional: id
							getAsJson : function(id) {
								var queryPart = {

								};
								if (id !== undefined && id !== null) {
									queryPart.id = id;

								}
								path2 = path2 + '?' + $.param(queryPart);
								return $.ajax(path2, {
									type : "GET",
									headers : {
										Accept : "application/json"
									}

								});

							}
							// Required: Optional: id
							,
							getAsXml : function(id) {
								var queryPart = {

								};
								if (id !== undefined && id !== null) {
									queryPart.id = id;

								}
								path2 = path2 + '?' + $.param(queryPart);
								return $.ajax(path2, {
									type : "GET",
									headers : {
										Accept : "application/xml"
									}

								});

							}

						};

					}

				};

			}

		};

	}

};
