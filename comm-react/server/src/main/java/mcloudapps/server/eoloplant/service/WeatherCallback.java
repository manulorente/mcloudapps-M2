package mcloudapps.server.eoloplant.service;

import io.grpc.stub.StreamObserver;

import mcloudapps.WeatherResponse;

public class WeatherCallback implements StreamObserver<WeatherResponse> {

	public WeatherCallback() {
	}

	@Override
	public void onNext(WeatherResponse value) {
		System.out.println("Received weather " + value.getWeather());
	}

	@Override
	public void onError(Throwable t) {
		System.out.println("Error occurred, cause " + t.getMessage());
		
	}

	@Override
	public void onCompleted() {
		System.out.println("Stream completed");
		
	}


}