# esb
Message message = EsbClient.http(_url).from(from).header(header).request(content).send();
Message message = EsbClient.rpc(url).from(from).header(header).request(content).send();
