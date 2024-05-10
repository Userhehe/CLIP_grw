//package com.clip.gwr.conf;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisPassword;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.GenericToStringSerializer;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//
//@Configuration
//@EnableRedisHttpSession(redisNamespace = "clip", maxInactiveIntervalInSeconds = 600)
//public class RedisConfig {
//	//	패스워드를 객체화시켜서 담아줘야한다
//	private RedisPassword password = RedisPassword.of("1004");
//	
//	//	커넥션 정보가 담겨있는 Configuration 객체 생성
//	public RedisStandaloneConfiguration configuration() {
//		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
//		redisStandaloneConfiguration.setHostName("localhost");
//		redisStandaloneConfiguration.setPort(6379);
//		redisStandaloneConfiguration.setPassword(password);;
//		redisStandaloneConfiguration.setDatabase(0);
//		return redisStandaloneConfiguration;
//	}
//	
//	//	Redis 서버와 연결을 위한 Connection Factory
//	@Bean
//	public RedisConnectionFactory connectionFactory() {
//		return new LettuceConnectionFactory(configuration());
//	}
//	
//	//  Redis에서 java로 가져오는 객체는 직렬화된 Data이기때문에 반드시 String타입으로 직렬화해주는 StringRedisSerializer 설정을 해줘야 값을 확인 가능하다
//	//	Session에 저장할객체(vo)도 반드시 implements Serializable 한 상태이어야 한다
//    public StringRedisSerializer serializer() {
//        return new StringRedisSerializer();
//    }
//    
//    // 일반적인 값이 아닌 객체를 Redis에 저장하거나 불러올때 사용되는 Jackson2JsonRedisSerializer
//    // json타입으로 변환해 직렬화시켜 저장해준다(vo 같은 객체를 저장하기 수월함)
//    @SuppressWarnings("rawtypes")
//    public Jackson2JsonRedisSerializer jsonRedisSerializer() {
//    	return new Jackson2JsonRedisSerializer<>(Object.class); 
//    }
//	
//    //	java에서 Redis 명령어나 각종 기능들을 사용하기 위한 템플릿 설정 Bean
//	@Bean
//    public RedisTemplate<String, Integer> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//		RedisTemplate<String, Integer> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new GenericToStringSerializer<>(Integer.class));
//        return redisTemplate;
//    }
//}
