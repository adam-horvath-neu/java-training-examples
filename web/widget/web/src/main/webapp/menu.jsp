
<style>
#menu a {
	text-decoration: none;
}

#menu {
	width: 200px;
}
</style>

<ul id="menu">
	<li class="ui-widget-header">Original examples</li>
	<li><a href="jqueryUI.jsp">jQueryUI</a></li>
	<li><a href="datatable.jsp">Datatable</a></li>
	<li class="ui-widget-header">Examples</li>
	<li><a href="accordation.jsp">Accordation</a></li>
	<li><a href="autocomplete.jsp">Autocomplete</a></li>
	<li><a href="datatableAjax.jsp">DatatableAjax</a></li>
	<li><a href="crudAjax.jsp">CrudAjax</a></li>

</ul>
<script>
	$(function() {
		$("#menu").menu({
			items : "> :not(.ui-widget-header)"
		});
	});
</script>
