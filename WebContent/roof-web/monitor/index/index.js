var treeObj = null;
var firstAsyncSuccessFlag = 0;
$(document).ready(function() {
	$('iframe').height(jQuery(window).height() - 40);
	var setting = {
		async : {
			enable : true,
			url : ROOF.Utils.projectName() + "/monitorHistoryAction/read.json",
			autoParam : [ "id" ]
		},
		view : {
			selectedMulti : false
		},
		edit : {
			enable : true,
			showRemoveBtn : false,
			showRenameBtn : false,
			drag : {
				isCopy : false,
				isMove : true
			}
		},
		data: {
			key: {
				title: "title"
			}
		},
		callback : {
			onClick : function(event, treeId, node) {
				var params = getAllParams(node);
				$('iframe').attr("src", ROOF.Utils.projectName() + "/monitorHistoryAction/detail.action?id=" + node.id+"&"+params);
			},
			onAsyncSuccess : function() {
				if (firstAsyncSuccessFlag == 0) {
					var nodes = treeObj.getNodes();
					treeObj.expandNode(nodes[0], true);
					treeObj.selectNode(nodes[0]);	
					firstAsyncSuccessFlag = 1;
				}
			},
			beforeDrop : function(treeId, treeNodes, targetNode, moveType, isCopy) {
				if (confirm("是否移动选中节点到[" + targetNode.name + "]下!")) {
					return true;
				} else {
					return false;
				}
			}
		}
	};
	treeObj = $.fn.zTree.init($('.ztree'), setting);
});
function reAsyncChildNodes() {
	var nodes = treeObj.getSelectedNodes();
	if (nodes.length > 0) {
		nodes[0].isParent = true;
		treeObj.reAsyncChildNodes(nodes[0], "refresh");
	}
}

function reAsyncParentChildNodes() {
	var nodes = treeObj.getSelectedNodes();
	if (nodes.length > 0) {
		treeObj.reAsyncChildNodes(nodes[0].getParentNode(), "refresh");
	}
}

/*
 * node:当前节点
 * target_anc_level : 目标祖先节点对应的level等级(默认为0,最顶层节点)
 * */
function getAllParams (node,target_anc_level){
	if(!target_anc_level){
		target_anc_level = 0;
	}
	var cur_level = node.level;
	var allParams = [];
	for(var i = target_anc_level;i <= cur_level;i++){
		var params = getParams(node);
		if(params){
			allParams.push(params);	
		}
		node = node.getParentNode();
	}
	return allParams.reverse().join('&');
}

/*
 * 获取当前节点挂的参数
 * */
function getParams (node){
	var url = node.url;
	if(url.lastIndexOf("?") == -1){
		return "";
	}
	return url.substr(url.lastIndexOf("?")+1);
}
