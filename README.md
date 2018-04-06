# Medical-Expert-System


### 메디컬 Expert 시스템을 위한 Drools와 JavaFX 기반의 사용자 인터페이스 설계 및 구현

본 논문은 Medical Expert 시스템을 효율적으로 운영하기 위해서 Drools 와 JavaFX기반으로 한 사용자 인터페이스를 설계 및 구현을 한다. 본 Medical Expert System을 구축하기 위하여 Drools의 내부의 구조인 BlackBoard 아키텍처 스타일을 이해하고 JavaFX을 이용하여 Medical Expert 시스템을 설계 및 구현 하였다. 이 시스템의 진행 프로세스는, 설문지 및 환자 진단으로 인해 환자에 대한 증상정보들을 파악 후 미리 정해 둔 rule들에 적용시켜서 그 결과 값을 도출한다. 또한 본 시스템은 JavaFX에 scene builder 이용하여 인터페이스를 구성함으로써 기존의 Swing의 단점을 보완하고 장점을 부각시키도록 구현하였다.

### Drools 기반의 메디컬 Expert 시스템 아키텍처와 프로세스 연구

본 논문은 병원에서 환자가 내원할 때 의사에게 환자 진단과 처방을 지원을 할 수 있는 메디컬 시스템에 대한 연구를 하였다. 메디컬 프로세스를 고려한 환자의 증상에 대한 파악과 진단, 처방에 이르기까지의 지원할 수 있는 병원의 증상 진단 지원 Expert System을 연구한다. 본 Expert System을 구축하기 위하여 오픈소스 프로젝트인 Drools를 사용하였다. 본 시스템은 시스템 운영 중, 병원에서 사용하는 증상 진단 지원 rule들을 용이하게 추가하며 사용할 수 있도록 하며, 사용한 Drools의 호환성 해결과 다양한 기능성을 사용하기 위해 Maven을 이용한 증상 진단 지원 Expert System을 설계하였다. 이 시스템의 전체 구성 시스템 아키텍처뿐만 아니라, 환자가 증상을 입력한 이후의 환자 증상, 진단, 처방에 이르기까지의 병원에서 일어나는 프로세스를 구현 및 연구를 하였다.

![1234567](https://user-images.githubusercontent.com/26623547/38420093-34964aa8-3992-11e8-8a3e-c00376b94ead.JPG)


## Markdown을 사용하여 내용꾸미기

Markdown은 작문을 스타일링하기위한 가볍고 사용하기 쉬운 구문입니다. 여기에는 다음을위한 규칙이 포함됩니다.

```markdown
Syntax highlighted code block

# Header 1
## Header 2
### Header 3

- Bulleted
- List

1. Numbered
2. List

**Bold** and _Italic_ and `Code` text

[Link](url) and ![Image](src)
```

자세한 내용은 [GitHub Flavored Markdown](https://guides.github.com/features/mastering-markdown/).

### Support or Contact

readme 파일 생성에 추가적인 도움이 필요하면 [도움말](https://help.github.com/articles/about-readmes/) 이나 [contact support](https://github.com/contact) 을 이용하세요.