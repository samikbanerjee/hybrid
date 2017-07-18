

; Used Title property of authntication dialog window. It will wait for 8 seconds.
WinWaitActive("Authentication Required", "", 8)

; Send User ID In Used name text field.
Send("Your User Name")

; Press keyboard TAB key to move cursor on password text field.
Send("{TAB}")

;  Send Passoword In Password text field.
Send("Password")

; Press Keyboard ENTER key to select OK button.
Send("{ENTER}")