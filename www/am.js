window.amFunc = function(str){
    cordova.exec(function(su){console.log("ok")}, function(err){alert(err)},"HelloAlarm","am", [str]);
}
