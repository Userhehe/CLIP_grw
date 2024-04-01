$(function () {
    $('#jstree').jstree({
        'core': {
            'data': {
                'url': '/tree/data',
                'dataType': 'json'
            }
        }
    });
});

function addNode() {
    var ref = $('#jstree').jstree(true);
    var sel = ref.get_selected();
    if (!sel.length) { 
        alert('Please select a node to add.'); 
        return; 
    }
    sel = sel[0];
    ref.create_node(sel, {text: 'New Node'}, 'last', function () {
        alert('Node added.');
    });
}

function editNode() {
    var ref = $('#jstree').jstree(true);
    var sel = ref.get_selected();
    if (!sel.length) { 
        alert('Please select a node to edit.'); 
        return; 
    }
    sel = sel[0];
    ref.edit(sel);
}

function deleteNode() {
    var ref = $('#jstree').jstree(true);
    var sel = ref.get_selected();
    if (!sel.length) { 
        alert('Please select a node to delete.'); 
        return; 
    }
    ref.delete_node(sel);
}
