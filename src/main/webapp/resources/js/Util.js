function _DeleteDepartment(){
    this.deleteDepartment = function(id) {
        if (confirm("Are you sure?")){
            window.location = "/DeleteDepartment/?id=" + id;
        }
    }
}
    
var DeleteDepartment = new _DeleteDepartment;

