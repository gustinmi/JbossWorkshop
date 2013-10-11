
function trim(str, chars) {
    return ltrim(rtrim(str, chars), chars);
}

function ltrim(str, chars) {
    chars = chars || "\\s";
    return str.replace(new RegExp("^[" + chars + "]+", "g"), "");
}

function rtrim(str, chars) {
    chars = chars || "\\s";
    return str.replace(new RegExp("[" + chars + "]+$", "g"), "");
}

function clearInputFields() {
	var inputControls = document.getElementsByTagName('input');
	var i = 0;
	var element = null;

	for (i = 0; i <= inputControls.length; i++)
		element = inputControls[i];
	if (element != null && element.type != null
			&& (element.type == 'text' || element.type == 'file')) {
		try {
			element.value = "";
		} catch (x) {
			// do nothing, it won't hurt
		}
	}
}

function validateNumber(cValue)
{
	var regExCurrency = /^\d*[0-9]?$/;

	var originalText = cValue.value;
	var elementId = cValue.id;
	trimmedText = trim(originalText);

	if (trimmedText == '')
	{
		return;
	}
	if (trimmedText.search(regExCurrency)==-1)
	{
		obj = document.getElementById("err_" + elementId);
		obj.style.display = "block";
		return;
	}
	
	//clear warning if exist from previous attempt
	obj = document.getElementById("err_" + elementId);
	if (obj.style.display == "block"){
		obj.style.display = "none";
	}
	
	cValue.value = trimmedText;
}



function isVisible(szDivID) // 1 visible, 0 hidden
{
    var obj = getObjectById(szDivID);
    if (document.layers)       //NN4+
    {
        return obj.display == "block";
    }
    else if (document.getElementById)      //gecko(NN6) + IE 5+
    {
        return obj.style.display == "block";
    }
    else if (document.all)    // IE 4
    {
        return obj.style.display == "block";
    }
    return null;
}

function toggleBox(szDivID, iState) // 1 visible, 0 hidden
{
    obj = getObjectById(szDivID);
    if (document.layers)       //NN4+
    {
        obj.display = (iState) ? "block" : "none";
    }
    else if (document.getElementById)      //gecko(NN6) + IE 5+
    {
        obj.style.display = (iState) ? "block" : "none";
    }
    else if (document.all)    // IE 4
    {
        obj.style.display = (iState) ? "block" : "none";
    }
}

function getObjectById(objId)
{
    if (document.layers)       //NN4+
    {
        return document.layers[objId];
    }
    else if (document.getElementById)      //gecko(NN6) + IE 5+
    {
        return document.getElementById(objId);
    }
    else if (document.all)    // IE 4
    {
        return document.all[objId];
    } else
    {
        return null;
    }
}

function setFocusOnTheFirstEditControl()
{
    var inputControls = document.getElementsByTagName('input');
    var i = 0;
    var element;
    for (i = 0; i <= inputControls.length; i++)
    {
        element = inputControls[i];

        if (element != null && element.type != null && (element.type == 'text' || element.type == 'file'))
        {
            while (element != null)
            {
                if (element.style.display == '')
                {
                    element = element.parentElement;
                }
				else if (element.style.display != 'none')
                {
                    inputControls[i].focus();
                    break;
                }
				else
                {
                    break;
                }
            }
        }
    }
}

function setFocusOnTheFirstTextarea()
{
    var inputControls = document.getElementsByTagName('textarea');
    var i = 0;
    var element;
    for (i = 0; i <= inputControls.length; i++)
    {
    	element = inputControls[i];
    	if (!element.readOnly)
    	{
    		inputControls[i].focus();
    		break;
    	}
    }
}

function formatValue(value) {
    value += '';
	x = value.split('.');
	x1 = x[0];
	x2 = x.length > 1 ? '.' + x[1] : '';
	var rgx = /(\d+)(\d{3})/;
	while (rgx.test(x1)) {
		x1 = x1.replace(rgx, '$1' + ',' + '$2');
	}
    var inverted = x1 + x2;
    var result = "";
    for (var i = 0; i < inverted.length; i++) {
        var char = inverted.charAt(i);
        if (char == '.') {
            result += ',';
        } else if (char == ',') {
            result += '.';
        } else {
            result += char;
        }
    }
    return result;
}

function replaceAll(value, symbolToReplace, symbolToReplaceWith) {
    var result = "";
    for (var i = 0; i < value.length; i++) {
        if (value.charAt(i) == symbolToReplace) {
            result += symbolToReplaceWith;
        } else {
            result += value.charAt(i);
        }
    }
    return result;
}

function checkForNaN(value) {
    if (isNaN(value)) {
        return 0.00;
    }
    return value;
}


function blockEnterKeystroke(event) {
    // block enter button.
    if (window.event.keyCode == 13) {
        return false;
    }
}

function initSearchByEnter(searchButtonId){
	var keycode;
	if (window.event){
		keycode = window.event.keyCode;
	}else {
		return true;
	}
	if (keycode == 13){ 
		getObjectById(searchButtonId).click();
		return false;
	}else {
		return true;
	}
}
