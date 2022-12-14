package com.c4soft.gh11822;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class SpringSecurity11822ApplicationTests {
	static final String TOKEN =
			"eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ2RHFNd2llMXVaWW9vY1J0V0FuSEotTGxqVTluRnZVcXhUWFJfZ1JzMThNIn0.eyJleHAiOjE2NjMyNzUzNjYsImlhdCI6MTY2MzI3MTc2NiwiYXV0aF90aW1lIjoxNjYzMjcxNzY1LCJqdGkiOiJmZWExODQ4NS01OTM1LTRhMjYtYTNmMy0zZmI4YTJmYjNhOTgiLCJpc3MiOiJodHRwczovL2JyYXZvLWNoNG1wOjg0NDMvcmVhbG1zL21hc3RlciIsImF1ZCI6WyJtYXN0ZXItcmVhbG0iLCJhY2NvdW50Il0sInN1YiI6IjA5OTIxZjc3LTIzZTQtNGU4Yi1iMzMyLTA0YzVjZTk0YWUwYSIsInR5cCI6IkJlYXJlciIsImF6cCI6InNwcmluZy1hZGRvbnMtcHVibGljIiwic2Vzc2lvbl9zdGF0ZSI6ImJkOGFmMjNhLTE0ZTItNDlkMi04MGEzLWYxNzVmMzFiOGNhZiIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiaHR0cHM6Ly9icmF2by1jaDRtcDo0MjAwIiwiaHR0cHM6Ly9sb2NhbGhvc3QiLCJodHRwczovL2xvY2FsaG9zdDo0MjAwIiwiaHR0cHM6Ly9sb2NhbGhvc3Q6ODEwMCIsImh0dHBzOi8vYnJhdm8tY2g0bXA6ODEwMCJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsiY3JlYXRlLXJlYWxtIiwiZGVmYXVsdC1yb2xlcy1tYXN0ZXIiLCJvZmZsaW5lX2FjY2VzcyIsImFkbWluIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJtYXN0ZXItcmVhbG0iOnsicm9sZXMiOlsidmlldy1pZGVudGl0eS1wcm92aWRlcnMiLCJ2aWV3LXJlYWxtIiwibWFuYWdlLWlkZW50aXR5LXByb3ZpZGVycyIsImltcGVyc29uYXRpb24iLCJjcmVhdGUtY2xpZW50IiwibWFuYWdlLXVzZXJzIiwicXVlcnktcmVhbG1zIiwidmlldy1hdXRob3JpemF0aW9uIiwicXVlcnktY2xpZW50cyIsInF1ZXJ5LXVzZXJzIiwibWFuYWdlLWV2ZW50cyIsIm1hbmFnZS1yZWFsbSIsInZpZXctZXZlbnRzIiwidmlldy11c2VycyIsInZpZXctY2xpZW50cyIsIm1hbmFnZS1hdXRob3JpemF0aW9uIiwibWFuYWdlLWNsaWVudHMiLCJxdWVyeS1ncm91cHMiXX0sImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIGVtYWlsIHByb2ZpbGUgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiJiZDhhZjIzYS0xNGUyLTQ5ZDItODBhMy1mMTc1ZjMxYjhjYWYiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwibmFtZSI6IkrDqXLDtG1lIFdhY29uZ25lIiwicHJlZmVycmVkX3VzZXJuYW1lIjoiYWRtaW4iLCJnaXZlbl9uYW1lIjoiSsOpcsO0bWUiLCJmYW1pbHlfbmFtZSI6IldhY29uZ25lIiwiZW1haWwiOiJqd2Fjb25nbmVAZnJlZS5mciJ9.g-R0NXTk2uxlLgx8y24WBfH2puHg3CLFqpCWYAybhAGD9SydhXvUd7xjquHhLwGW-Pd61P8O76dbzgGk4W6emvgfGE_YP3keJ4C3Bm40G7-FNEEbGvi5cqJO7LTHl-HI9AQTEQpaK_Qp01-SE5fcYtIfePa4kVQCw-JRAAmD24r4bIV1R7MOwWg8Qj3erYmRr2upgNx1lrrKVDNt954unRzOtcU-XSz4JJdElNoo3pwHCuZwc3q6_B-LDfAjDc4qy_EpB_A-bRWfLgaWJpIyvMWosV9tKRkEPXVVZScHILoAyiMEaXpnhEBciVhf61D0LTmKf0nxVt2mg4MWRlTZUQ";
	@Autowired
	WebTestClient client;

	@Test
	void whenUserIsAuthenticatedThenCanAccessDemoGh11822() {
		client.get().uri("/demo/gh-11822").headers(h -> h.setBearerAuth(TOKEN)).exchange().expectStatus().isOk().expectBody().equals("success");
	}

}
