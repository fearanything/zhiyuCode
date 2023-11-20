package com.fh.entity.menubase;

/**
 * @author laogui 
 * 二级菜单
 */
public class ComButton extends Button {
	private Button[] subButton;

	public Button[] getSubButton() {
		return subButton;
	}

	public void setSubButton(Button[] subButton) {
		this.subButton = subButton;
	}

}
