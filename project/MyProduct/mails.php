<?php

sleep(2);

$mail = new stdClass();
$mail->id = 1;
$mail->sender = 'Kimchhung';
$mail->subject = 'Hello';
$mail->body = 'How are you?';
$mail->senderProfile = 'https://rupp-ite.s3.ap-southeast-1.amazonaws.com/acer.jpg';

$mail2 = new stdClass();
$mail2->id = 2;
$mail2->sender = '2nd me is me';
$mail2->subject = 'Hi';
$mail2->body = 'How do you do?';
$mail2->senderProfile = 'https://rupp-ite.s3.ap-southeast-1.amazonaws.com/dell.jpg';

$mail3 = new stdClass();
$mail3->id = 3;
$mail3->sender = 'LLLLLOOOOOOOOO';
$mail3->subject = 'hihi';
$mail3->body = 'Bye bye';
$mail3->senderProfile = 'https://rupp-ite.s3.ap-southeast-1.amazonaws.com/vaio.jpg';
$mails = array($mail, $mail2, $mail3);

$json = json_encode($mails);

echo $json;
