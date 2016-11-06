public static List<Rola> getRoles(String wdauth) {
        String url = mainUrl + "/wd-auth/roles?wdauth=" + wdauth;

        try {
            SSLContextBuilder builder = new SSLContextBuilder();
            builder.loadTrustMaterial(null, (x509Certificates, s) -> true);   //new TrustStrategy
            HostnameVerifier verifier = (hostname, session) -> true;    //new HostnameVerifier

            SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(builder.build(), verifier);
            CloseableHttpClient client = HttpClients.custom()
                    .setSSLSocketFactory(socketFactory)
                    .build();

            HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
            requestFactory.setHttpClient(client);
            //adding wdauth
            HttpHeaders requestHeaders = new HttpHeaders();
//            requestHeaders.add("Cookie", "wdauth=" + wdauth);
            HttpEntity requestEntity = new HttpEntity(null, requestHeaders);

            ResponseEntity<List<Rola>> res = new RestTemplate(requestFactory)
                    .exchange(url, HttpMethod.GET, requestEntity,
                            new ParameterizedTypeReference<List<Rola>>() {
                            });
            return res.getBody();
        } catch (Exception e) {
            log.info("Error getting roles for [{}]", wdauth);
        }
        return new ArrayList<>();
    }
