class UrlMappings {

	static mappings = {
		
		"/release/calendar"(controller: "relCalRest") {
			action = [GET: "list", POST: "save" ]
		}
		
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
