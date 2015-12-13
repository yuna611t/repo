describe("greet test", function(){
    it("returns Hello,taro", function(){
        expect( greet("taro") ).toEqual("Hello,taro");
    });
});
