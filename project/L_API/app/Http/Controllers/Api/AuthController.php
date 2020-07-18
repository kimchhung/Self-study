<?php

namespace App\Http\Controllers\Api;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Hash;
use Exception;
use App\User;
use App\product;
use Tymon\JWTAuth\Facades\JWTAuth;


class AuthController extends Controller
{
    public function login(Request $request){

      $creds = $request->only(['email','password']);

      if (!$token=auth()->attempt($creds)){
        // code...
        return response()->json([
          'success' => false,
          'message' => 'Invalid credintials'
        ]);
      }

      return response()->json([
        'success'=>true,
        'token'=> $token,
        'user'=> Auth::user()
      ]);
    }

    public function register(Request $request){
      $encryptedPass = Hash::make($request->password);
      $user = new User;

      try{
        $user->name = $request->name;
        $user->email = $request->email;
        $user->password = $encryptedPass;
        $user->save();
        return $this->login($request);
      }
      catch(Exception $e){
        return response()->json([
          'success'=>false,
          'message'=>$e
        ]);
      }
    }

    public function logout(Request $request){
      try {
        JWTAuth::invalidate(JWTAuth::parseToken($request->token));
        return response()->json([
          'success'=>true,
          'message'=>'logout success'
        ]);
      } catch (Exception $e) {

      }

    }

    public function getproduct(Request $request){
      try{
        $products = product::all()->toJson();
        return $products;
      }
      catch(Exception $e){
        return response()->json([
          'success'=>false,
          'message'=>$e
        ]);
      }
    }


}
